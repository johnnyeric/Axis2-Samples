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

package org.apache.axis2.api.builder;

import org.apache.axis2.builder.Builder;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.AxisFault;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPEnvelope;

import java.io.InputStream;
import java.io.IOException;

public class CustomMessageBuilder implements Builder {

    public OMElement processDocument(InputStream inputStream, String contentType, MessageContext messageContext) throws AxisFault {

        SOAPFactory soapFactory = OMAbstractFactory.getSOAP11Factory();
        SOAPEnvelope soapEnvelope = soapFactory.getDefaultEnvelope();

        OMNamespace omNamespace = soapFactory.createOMNamespace("http://org.apache.axis2.api", "ns1");
        OMElement requestElement = soapFactory.createOMElement("Request", omNamespace);

        byte[] inputBuffer = new byte[1024];
        try {
            int readBytes = inputStream.read(inputBuffer);
            String readString = new String(inputBuffer,0, readBytes);
            String[] nameValues = readString.split("\n");
            for (String nameValue : nameValues){
                String[] nameValuePair = nameValue.split(",");
                OMElement childElement = soapFactory.createOMElement(nameValuePair[0], omNamespace);
                childElement.setText(nameValuePair[1]);
                requestElement.addChild(childElement);
            }
            soapEnvelope.getBody().addChild(requestElement);
        } catch (IOException e) {
            throw new AxisFault("Can not read from the input stream");
        }

        return soapEnvelope;
    }
}
