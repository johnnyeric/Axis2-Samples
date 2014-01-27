/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.module.handler;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.*;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.handlers.AbstractHandler;


public class SampleOutFlowHandler extends AbstractHandler {
    public InvocationResponse invoke(MessageContext messageContext) throws AxisFault {
        // lets add an Soap header for the out going message
        SOAPEnvelope soapEnvelope = messageContext.getEnvelope();

        if (soapEnvelope.getHeader() == null) {
            String soapNamespace = soapEnvelope.getNamespace().getNamespaceURI();
            // creating a soap factory according the the soap namespce uri
            SOAPFactory soapFactory = null;
            if (soapNamespace.equals(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI)) {
                soapFactory = OMAbstractFactory.getSOAP11Factory();
            } else if (soapNamespace.equals(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI)) {
                soapFactory = OMAbstractFactory.getSOAP12Factory();
            } else {
                System.out.println("Unknow soap message");
            }
            soapFactory.createSOAPHeader(soapEnvelope);
        }

        OMNamespace omNamespace = OMAbstractFactory.getOMFactory().createOMNamespace("http://sample.module","ns1");
        SOAPHeaderBlock soapHeaderBlock = soapEnvelope.getHeader().addHeaderBlock("SampleOutHeader",omNamespace);
        soapHeaderBlock.setText("Test Header");

        return InvocationResponse.CONTINUE;
    }
}
