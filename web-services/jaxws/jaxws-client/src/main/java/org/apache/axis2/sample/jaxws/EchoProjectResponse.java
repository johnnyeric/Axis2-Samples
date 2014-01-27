
package org.apache.axis2.sample.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for echoProjectResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="echoProjectResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http//axis2.apache.org/sample/jaxws/types}Project" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "echoProjectResponse", propOrder = {
    "_return"
})
public class EchoProjectResponse {

    @XmlElement(name = "return")
    protected Project _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link org.apache.axis2.sample.jaxws.Project }
     *     
     */
    public Project getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.apache.axis2.sample.jaxws.Project }
     *     
     */
    public void setReturn(Project value) {
        this._return = value;
    }

}
