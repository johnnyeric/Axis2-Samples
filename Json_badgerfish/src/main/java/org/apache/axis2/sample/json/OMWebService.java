package org.apache.axis2.sample.json;

import org.apache.axiom.om.*;
import org.apache.axis2.json.JSONBadgerfishDataSource;

import javax.xml.stream.XMLStreamException;

public class OMWebService {

    public OMElement echoOMElement(OMElement omElement) {
        omElement.setLocalName(omElement.getLocalName() + "Response"); return omElement;
    }

    public void ping(OMElement omElement) {
        System.out.println(omElement.getLocalName());
    }

    public OMElement echoOM(OMElement omEle) {
        OMDataSource omdataOSuce = ((OMSourcedElement) omEle).getDataSource();
        OMElement newOmEle = (OMElement) omEle.detach();
        ((OMSourcedElement) newOmEle).setDataSource(omdataOSuce);
        try {
            omEle.serialize(System.out);
        } catch (XMLStreamException e) {
            System.out.println("XMLStreamException thrown");
        }
        return omEle;
    }

    public OMElement getOM() {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace ns = factory.createOMNamespace("", "");
        OMElement OMEle = factory.createOMElement("data", ns);
        OMElement firstChild = factory.createOMElement("test", ns);
        OMEle.addChild(firstChild);
        return OMEle;
    }

    public void getJsonString(OMElement omEle) {
        JSONBadgerfishDataSource jsonDataSource = (JSONBadgerfishDataSource) ((OMSourcedElement) omEle).getDataSource();
        String jsonString = jsonDataSource.getCompleteJOSNString(); // this will return json string
        System.out.println(jsonString);
    }

}
