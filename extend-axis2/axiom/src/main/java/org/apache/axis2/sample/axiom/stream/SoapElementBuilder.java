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

import org.apache.axiom.om.util.StAXUtils;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.impl.builder.StAXSOAPModelBuilder;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;

public class SoapElementBuilder {

    private static SOAPEnvelope buildSoapEnvelope() {

        String xmlString = "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "    <soapenv:Body>\n" +
                "        <ns1:Project xmlns:ns1=\"http://axis2.apache.org/sample\">\n" +
                "            <ns1:Developer>\n" +
                "                <ns1:name>AAA</ns1:name>\n" +
                "                <ns1:location>Colombo</ns1:location>\n" +
                "            </ns1:Developer>\n" +
                "        </ns1:Project>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        SOAPEnvelope soapEnvelope = null;
        try {
            XMLStreamReader xmlStreamReader =
                    StAXUtils.createXMLStreamReader(new ByteArrayInputStream(xmlString.getBytes()));
            StAXSOAPModelBuilder stAXSOAPModelBuilder = new StAXSOAPModelBuilder(xmlStreamReader);
            soapEnvelope = stAXSOAPModelBuilder.getSOAPEnvelope();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return soapEnvelope;
    }

    public static void main(String[] args) {

        try {
            SOAPEnvelope soapEnvelope = buildSoapEnvelope();
            soapEnvelope.serialize(System.out);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
