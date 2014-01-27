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

package org.apache.axis2.sample.axiom.stream;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.StAXUtils;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;

public class OMElementBuilder {

    private static OMElement buildOMElement() {
        String xmlString = "<ns1:Project xmlns:ns1=\"http://axis2.apache.org/sample\">\n" +
                "    <ns1:Developer>\n" +
                "        <ns1:name>AAA</ns1:name>\n" +
                "        <ns1:location>Colombo</ns1:location>\n" +
                "    </ns1:Developer>\n" +
                "</ns1:Project>";
        OMElement omElement = null;
        try {
            XMLStreamReader xmlStreamReader =
                    StAXUtils.createXMLStreamReader(new ByteArrayInputStream(xmlString.getBytes()));
            StAXOMBuilder stAXOMBuilder = new StAXOMBuilder(xmlStreamReader);
            omElement = stAXOMBuilder.getDocumentElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return omElement;
    }

    private static void serialize() {
        try {
            OMElement omElement = buildOMElement();
            omElement.serialize(System.out);

            // once agagain
            omElement.serialize(System.out);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static void serializeAndConsume() {
        try {
            OMElement omElement = buildOMElement();
            omElement.serializeAndConsume(System.out);

            // once agagain
            omElement.serializeAndConsume(System.out);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        serialize();
        serializeAndConsume();
    }
}
