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

package org.apache.axis2.sample.rm.client;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.axis2.Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.sample.rm.types.Employee;
import org.apache.sandesha2.client.SandeshaClientConstants;
import org.apache.sandesha2.client.SandeshaClient;
import org.apache.sandesha2.Sandesha2Constants;

public class RMAnonymous {

    private void inOnlyClient() {

        try {
            ConfigurationContext configurationContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(
                            "rm_client/repository", "rm_client/conf/axis2.xml");
            RMServiceStub stub =
                    new RMServiceStub(configurationContext,
                            "http://localhost:8088/axis2/services/RMService.RMServiceHttpSoap12Endpoint/");
            stub._getServiceClient().engageModule("sandesha2");

//            stub._getServiceClient().getOptions().setProperty(SandeshaClientConstants.RM_SPEC_VERSION, Sandesha2Constants.SPEC_VERSIONS.v1_1);
            stub._getServiceClient().getOptions().setProperty(SandeshaClientConstants.LAST_MESSAGE, Constants.VALUE_TRUE);
            Employee employee = new Employee();
            employee.setAge(32);
            employee.setName("AAA");
            employee.setSalary(234.56);

            stub.setEmployee(employee);

            try {
                Thread.sleep(200000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }

    }

    private void inOutClient() {

        try {
            ConfigurationContext configurationContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(
                            "rm_client/repository", "rm_client/conf/axis2.xml");
            RMServiceStub stub =
                    new RMServiceStub(configurationContext,
                            "http://localhost:8088/axis2/services/RMService.RMServiceHttpSoap12Endpoint/");
            stub._getServiceClient().engageModule("sandesha2");

//            stub._getServiceClient().getOptions().setProperty(SandeshaClientConstants.RM_SPEC_VERSION, Sandesha2Constants.SPEC_VERSIONS.v1_1);

            Employee employee = new Employee();
            employee.setAge(32);
            employee.setName("AAA");
            employee.setSalary(234.56);

            RMServiceCallbackHandler callback = new RMServiceCallbackHandler() {

                public void receiveResultechoEmployee(Employee result) {
                    System.out.println("Employee ==> " + result.getName());
                }
            };

            stub.startechoEmployee(employee, callback);
            SandeshaClient.terminateSequence(stub._getServiceClient());

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        new RMAnonymous().inOnlyClient();
        new RMAnonymous().inOutClient();
    }
}
