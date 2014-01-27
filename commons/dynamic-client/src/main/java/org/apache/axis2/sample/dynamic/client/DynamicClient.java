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

import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMFactory;

import javax.xml.namespace.QName;
import java.net.URL;
import java.net.MalformedURLException;

public class DynamicClient {

    public static void main(String[] args) {

        try {
            ServiceClient serviceClient = new ServiceClient(null,
                    new URL("http://localhost:8080/axis2/services/DynamicService?wsdl"),
                    new QName("http//axis2.apache.org/sample/dynamic", "DynamicService"),
                    "DynamicServiceHttpSoap11Endpoint");

            // end point address is read from the wsdl
            OMElement result =
                    serviceClient.sendReceive(
                            new QName("http//axis2.apache.org/sample/dynamic","echoEmployee"),
                            getBodyElement());
            System.out.println("Result ==> " + result);

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static OMElement getBodyElement(){
        OMFactory omFactory = OMAbstractFactory.getOMFactory();
        OMElement echoEmployeeElement =
                omFactory.createOMElement("echoEmployee","http//axis2.apache.org/sample/dynamic/types", null);
        OMElement employeeElement =
                omFactory.createOMElement("employee","http//axis2.apache.org/sample/dynamic/types", null);
        OMElement ageElement =
                omFactory.createOMElement("age","http//axis2.apache.org/sample/dynamic/types", null);
        ageElement.setText("32");
        OMElement nameElement =
                omFactory.createOMElement("name","http//axis2.apache.org/sample/dynamic/types", null);
        nameElement.setText("AAA");
        OMElement salaryElement =
                omFactory.createOMElement("salary","http//axis2.apache.org/sample/dynamic/types", null);
        salaryElement.setText("5000.89");

        employeeElement.addChild(ageElement);
        employeeElement.addChild(nameElement);
        employeeElement.addChild(salaryElement);

        echoEmployeeElement.addChild(employeeElement);

        return echoEmployeeElement;

    }
}
