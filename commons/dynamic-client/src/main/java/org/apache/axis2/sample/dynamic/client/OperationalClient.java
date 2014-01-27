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

package org.apache.axis2.sample.dynamic.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.MessageContext;


public class OperationalClient {

    public static void main(String[] args) {
        try {
            ServiceClient serviceClient = new ServiceClient();
            OperationClient opClient = serviceClient.createClient(ServiceClient.ANON_OUT_IN_OP);
            //creating message context
            MessageContext outMsgCtx = new MessageContext();
            //assigning message contexts option object into instance variable
            Options opts = outMsgCtx.getOptions();
            //setting properties into option
            opts.setTo(new EndpointReference(
                    "http://localhost:8080/axis2/services/DynamicService.DynamicServiceHttpSoap11Endpoint/"));
            opts.setAction("urn:echoEmployee");
            outMsgCtx.setEnvelope(creatSOAPEnvelop());
            opClient.addMessageContext(outMsgCtx);
            opClient.execute(true);

            MessageContext inMsgtCtx = opClient.getMessageContext("In");

            SOAPEnvelope response = inMsgtCtx.getEnvelope();
            System.out.println(response);
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public static SOAPEnvelope creatSOAPEnvelop() {
        SOAPFactory fac = OMAbstractFactory.getSOAP11Factory();
        SOAPEnvelope envelope = fac.getDefaultEnvelope();
        envelope.getBody().addChild(getBodyElement());
        return envelope;
    }

    private static OMElement getBodyElement() {
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMElement echoEmployeeElement =
                omFactory.createOMElement("echoEmployee", "http//axis2.apache.org/sample/dynamic/types", null);
        OMElement employeeElement =
                omFactory.createOMElement("employee", "http//axis2.apache.org/sample/dynamic/types", null);
        OMElement ageElement =
                omFactory.createOMElement("age", "http//axis2.apache.org/sample/dynamic/types", null);
        ageElement.setText("32");
        OMElement nameElement =
                omFactory.createOMElement("name", "http//axis2.apache.org/sample/dynamic/types", null);
        nameElement.setText("AAA");
        OMElement salaryElement =
                omFactory.createOMElement("salary", "http//axis2.apache.org/sample/dynamic/types", null);
        salaryElement.setText("5000.89");

        employeeElement.addChild(ageElement);
        employeeElement.addChild(nameElement);
        employeeElement.addChild(salaryElement);

        echoEmployeeElement.addChild(employeeElement);

        return echoEmployeeElement;

    }
}
