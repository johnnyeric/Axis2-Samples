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

package org.apache.axis2.sample.axiom.api;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class OMElementcreator {

    private static OMElement createOMElement(){

//        <ns1:Project xmlns:ns1="http://axis2.apache.org/sample">
//            <ns1:Developer>
//                <ns1:name>AAA</ns1:name>
//                <ns1:location>Colombo</ns1:location>
//            </ns1:Developer>
//        </ns1:Project>

        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace ns = factory.createOMNamespace("http://axis2.apache.org/sample", "ns1");
        OMElement projectElement = factory.createOMElement("Project", ns);
        OMElement developerElement = factory.createOMElement("Developer", ns, projectElement);
        OMElement nameElement = factory.createOMElement("name", ns, developerElement);
        nameElement.setText("AAA"); //set the text
        OMElement locationElement = factory.createOMElement("location", ns, developerElement);
        locationElement.setText("Colombo"); //set the text

        return projectElement;
    }

    public static void main(String[] args) {
        OMElement omElement = createOMElement();
        System.out.println("OMElement ==> " + omElement.toString());
    }
}
