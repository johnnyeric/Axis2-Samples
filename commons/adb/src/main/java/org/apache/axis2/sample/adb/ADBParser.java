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

package org.apache.axis2.sample.adb;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.util.StAXUtils;
import org.apache.axis2.databinding.ADBException;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;

public class ADBParser {

    public static void main(String[] args) {

        EchoEmployee echoEmployee = new EchoEmployee();

        Employee employee = new Employee();
        employee.setAge(25);
        employee.setName("AAA");
        employee.setSalary(234.45);

        echoEmployee.setEmployee(employee);

        try {
            OMElement echoEmployeeElement =
                    echoEmployee.getOMElement(EchoEmployee.MY_QNAME,
                            OMAbstractFactory.getOMFactory());
            String omElementString = echoEmployeeElement.toStringWithConsume();
            System.out.println("Element String ==> " + omElementString);

            XMLStreamReader xmlStreamReader =
                    StAXUtils.createXMLStreamReader(new ByteArrayInputStream(omElementString.getBytes()));
            EchoEmployee result = EchoEmployee.Factory.parse(xmlStreamReader);

            System.out.println("Age ==> " + result.getEmployee().getAge());
            System.out.println("Name ==> " + result.getEmployee().getName());
            System.out.println("Salary ==> " + result.getEmployee().getSalary());

        } catch (ADBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
