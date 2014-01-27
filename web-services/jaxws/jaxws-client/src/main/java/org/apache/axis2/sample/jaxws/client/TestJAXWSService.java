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

package org.apache.axis2.sample.jaxws.client;

import org.apache.axis2.sample.jaxws.JAXWSServiceService;
import org.apache.axis2.sample.jaxws.JAXWSService;
import org.apache.axis2.sample.jaxws.Project;
import org.apache.axis2.sample.jaxws.Employee;

public class TestJAXWSService {

    public static void main(String[] args) {

        JAXWSServiceService service = new JAXWSServiceService();
        JAXWSService jaxwsService = service.getJAXWSServicePort();
        String result = jaxwsService.echoString("hello");
        System.out.println("Result ==> " + result);

        Project project = new Project();
        project.setName("axis2");

        Employee manager = new Employee();
        manager.setAge(40);
        manager.setEmpID("E1");
        manager.setName("AAAA");
        manager.setSalary(345.78);

        project.setManager(manager);

        Employee[] develpers = new Employee[2];
        develpers[0] = new Employee();
        develpers[0].setAge(34);
        develpers[0].setEmpID("E2");
        develpers[0].setName("BBBB");
        develpers[0].setSalary(3451.78);

        develpers[1] = new Employee();
        develpers[1].setAge(34);
        develpers[1].setEmpID("E3");
        develpers[1].setName("CCCC");
        develpers[1].setSalary(3452.78);

        project.getDevelopers().add(develpers[0]);
        project.getDevelopers().add(develpers[1]);

        jaxwsService.echoProject(project);
    }

}
