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

package org.apache.axis2.sample.rest;

import org.apache.axis2.AxisFault;
import org.apache.axis2.sample.rest.types.Student;
import org.apache.axis2.sample.rest.types.StudentName;

public class TestRestServiceStub {

    public static void main(String[] args) {
        try {
            RestServiceStub stub = new RestServiceStub("http://localhost:8088/axis2/services/RestService");
            Student student = new Student();
            student.setName("amila");
            student.setAge(32);
            student.setSubjects(new String[]{"maths", "science"});
            stub.add(student);

            StudentName studentName = new StudentName();
            studentName.setName("amila");
            Student result = stub.get(studentName);

            result.setAge(40);
            result.setSubjects(new String[]{"english", "history"});

            stub.update(result);

            result = stub.get(studentName);

            stub.delete(studentName);

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }
}
