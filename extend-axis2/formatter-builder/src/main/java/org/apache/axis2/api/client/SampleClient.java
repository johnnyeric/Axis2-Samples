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
package org.apache.axis2.api.client;

import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMElement;


public class SampleClient {

    public static final String AXIS2_CONF = "conf/axis2.xml";
    public static final String AXIS2_REPOSITORY = "repository";

    private void invokeService() {
        try {

            ConfigurationContext confContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(
                            AXIS2_REPOSITORY, AXIS2_CONF);


            ServiceClient serviceClient = new ServiceClient(confContext, null);

            serviceClient.setTargetEPR(new EndpointReference("http://localhost:8088/axis2/services/SampleService/SampleInOnlyOperation"));

            // invoking in only operation
            serviceClient.getOptions().setAction("urn:SampleInOnlyOperation");
            serviceClient.getOptions().setProperty(Constants.Configuration.MESSAGE_TYPE,"application/custom");
            serviceClient.fireAndForget(getOMElement());

            serviceClient.setTargetEPR(new EndpointReference("http://localhost:8088/axis2/services/SampleService/SampleInOutOperation"));

            // invoking in out operation
            serviceClient.getOptions().setAction("urn:SampleInOutOperation");
            OMElement response = serviceClient.sendReceive(getOMElement());

            System.out.println("Response ==> " + response.toString());

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    private OMElement getOMElement() {
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMNamespace omNamespace = omFactory.createOMNamespace("http://org.apache.axis2.api", "ns1");
        OMElement omElement = omFactory.createOMElement("Request", omNamespace);

        OMElement childElement = null;

        childElement = omFactory.createOMElement("name", omNamespace);
        childElement.setText("Amila Suriarachchi");
        omElement.addChild(childElement);

        childElement = omFactory.createOMElement("age", omNamespace);
        childElement.setText("33");
        omElement.addChild(childElement);

        childElement = omFactory.createOMElement("address", omNamespace);
        childElement.setText("Galle");
        omElement.addChild(childElement);

        return omElement;
    }

    public static void main(String[] args) {
        new SampleClient().invokeService();
    }
}
