
package org.apache.axis2.sample.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.axis2.sample.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EchoProjectResponse_QNAME = new QName("http//axis2.apache.org/sample/jaxws", "echoProjectResponse");
    private final static QName _EchoString_QNAME = new QName("http//axis2.apache.org/sample/jaxws", "echoString");
    private final static QName _EchoStringResponse_QNAME = new QName("http//axis2.apache.org/sample/jaxws", "echoStringResponse");
    private final static QName _EchoProject_QNAME = new QName("http//axis2.apache.org/sample/jaxws", "echoProject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.axis2.sample.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EchoString }
     * 
     */
    public EchoString createEchoString() {
        return new EchoString();
    }

    /**
     * Create an instance of {@link org.apache.axis2.sample.jaxws.Project }
     * 
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link org.apache.axis2.sample.jaxws.Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link EchoStringResponse }
     * 
     */
    public EchoStringResponse createEchoStringResponse() {
        return new EchoStringResponse();
    }

    /**
     * Create an instance of {@link EchoProject }
     * 
     */
    public EchoProject createEchoProject() {
        return new EchoProject();
    }

    /**
     * Create an instance of {@link org.apache.axis2.sample.jaxws.EchoProjectResponse }
     * 
     */
    public EchoProjectResponse createEchoProjectResponse() {
        return new EchoProjectResponse();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link org.apache.axis2.sample.jaxws.EchoProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http//axis2.apache.org/sample/jaxws", name = "echoProjectResponse")
    public JAXBElement<EchoProjectResponse> createEchoProjectResponse(EchoProjectResponse value) {
        return new JAXBElement<EchoProjectResponse>(_EchoProjectResponse_QNAME, EchoProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link EchoString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http//axis2.apache.org/sample/jaxws", name = "echoString")
    public JAXBElement<EchoString> createEchoString(EchoString value) {
        return new JAXBElement<EchoString>(_EchoString_QNAME, EchoString.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link EchoStringResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http//axis2.apache.org/sample/jaxws", name = "echoStringResponse")
    public JAXBElement<EchoStringResponse> createEchoStringResponse(EchoStringResponse value) {
        return new JAXBElement<EchoStringResponse>(_EchoStringResponse_QNAME, EchoStringResponse.class, null, value);
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link EchoProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http//axis2.apache.org/sample/jaxws", name = "echoProject")
    public JAXBElement<EchoProject> createEchoProject(EchoProject value) {
        return new JAXBElement<EchoProject>(_EchoProject_QNAME, EchoProject.class, null, value);
    }

}
