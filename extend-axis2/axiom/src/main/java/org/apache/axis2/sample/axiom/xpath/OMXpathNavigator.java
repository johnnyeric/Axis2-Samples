package org.apache.axis2.sample.axiom.xpath;


import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXBuilder;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.xpath.AXIOMXPath;

import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;


public class OMXpathNavigator {
    private static String sampleXML =
                    "<ns1:Project xmlns:ns1=\"http://axis2.apache.org/sample\">\n" +
                    "    <ns1:Developer>\n" +
                    "        <ns1:name>AAA</ns1:name>\n" +
                    "        <ns1:location>Colombo</ns1:location>\n" +
                    "    </ns1:Developer>\n" +
                    "    <ns1:Developer>\n" +
                    "        <ns1:name>BBB</ns1:name>\n" +
                    "        <ns1:location>London</ns1:location>\n" +
                    "    </ns1:Developer>\n" +
                    "</ns1:Project>";

    

    private static OMElement readElement() throws XMLStreamException {
        //Create an input stream for the string
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sampleXML.getBytes());
        //create a builder. Since we want the XML as a plain XML, we can just use
        //the plain OMBuilder
        StAXBuilder builder = new StAXOMBuilder(byteArrayInputStream);
        //return the root element.
        return builder.getDocumentElement();
    }

    public static void main(String[] args) throws Exception {
        OMElement rootElement = readElement();

        AXIOMXPath xpath = new AXIOMXPath("/ns2:Project/ns2:Developer[1]/ns2:name");
        xpath.addNamespace("ns2","http://axis2.apache.org/sample");
        OMElement selectedNode = (OMElement) xpath.selectSingleNode(rootElement);
        System.out.println(selectedNode.getText());

        xpath = new AXIOMXPath("/ns1:Project/ns1:Developer[2]/ns1:location");
        xpath.addNamespaces(rootElement);
        selectedNode = (OMElement) xpath.selectSingleNode(rootElement);
        System.out.println(selectedNode.getText());

    }
}
