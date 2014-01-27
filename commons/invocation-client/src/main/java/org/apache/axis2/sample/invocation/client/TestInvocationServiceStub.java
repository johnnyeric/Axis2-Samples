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

package org.apache.axis2.sample.invocation.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.sample.invocation.types.Employee;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;

public class TestInvocationServiceStub {

    private void testSyncSingleChanel(){

        try {
            InvocationServiceStub stub = new InvocationServiceStub(
                    "http://localhost:8088/axis2/services/InvocationService.InvocationServiceHttpSoap12Endpoint/");
            Employee employee = new Employee();
            employee.setName("AAA");
            employee.setAge(30);
            employee.setSalary(23456);
            Employee result = stub.echoEmployee(employee);
            System.out.println("Employee name ==> " + result.getName());
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }

    }

    private void testAsyncSingleChanel(){

        try {
            InvocationServiceStub stub = new InvocationServiceStub(
                    "http://localhost:8088/axis2/services/InvocationService.InvocationServiceHttpSoap12Endpoint/");
            Employee employee = new Employee();
            employee.setName("AAA");
            employee.setAge(30);
            employee.setSalary(23456);

            InvocationServiceCallbackHandler callback = new InvocationServiceCallbackHandler(){

                public void receiveResultechoEmployee(Employee result) {
                    System.out.println("Employee name ==> " + result.getName());
                    synchronized (this){
                        this.notify();
                    }
                }
                public void receiveErrorechoEmployee(Exception e) {
                   e.printStackTrace();
                }
            };

            stub.startechoEmployee(employee, callback);

            synchronized (callback){
                try {
                    callback.wait();
                } catch (InterruptedException e) {}
            }

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }

    }

    private void testSyncDualChanel(){

        try {
            // crate a configuration context to engage the addressing
            ConfigurationContext configurationContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(
                            "invocation_client/repository","invocation_client/conf/axis2.xml");

            InvocationServiceStub stub = new InvocationServiceStub(configurationContext,
                    "http://localhost:8088/axis2/services/InvocationService.InvocationServiceHttpSoap12Endpoint/");
            Employee employee = new Employee();
            employee.setName("AAA");
            employee.setAge(30);
            employee.setSalary(23456);

            //set use seperate listener true to make it dual channel
            stub._getServiceClient().getOptions().setUseSeparateListener(true);
            stub._getServiceClient().engageModule("addressing");

            Employee result = stub.echoEmployee(employee);
            System.out.println("Employee name ==> " + result.getName());
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }

    private void testAsyncDualChanel(){

        try {
            // crate a configuration context to engage the addressing
            ConfigurationContext configurationContext =
                    ConfigurationContextFactory.createConfigurationContextFromFileSystem(
                            "invocation_client/repository","invocation_client/conf/axis2.xml");

            InvocationServiceStub stub = new InvocationServiceStub(configurationContext,
                    "http://localhost:8088/axis2/services/InvocationService.InvocationServiceHttpSoap12Endpoint/");
            Employee employee = new Employee();
            employee.setName("AAA");
            employee.setAge(30);
            employee.setSalary(23456);

            //set use seperate listener true to make it dual channel
            stub._getServiceClient().getOptions().setUseSeparateListener(true);
            stub._getServiceClient().engageModule("addressing");

            InvocationServiceCallbackHandler callback = new InvocationServiceCallbackHandler(){

                public void receiveResultechoEmployee(Employee result) {
                    System.out.println("Employee name ==> " + result.getName());
                }
                public void receiveErrorechoEmployee(Exception e) {
                   e.printStackTrace();
                }
            };

            stub.startechoEmployee(employee, callback);
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        new TestInvocationServiceStub().testSyncSingleChanel();
//        new TestInvocationServiceStub().testAsyncSingleChanel();
//        new TestInvocationServiceStub().testSyncDualChanel();
        new TestInvocationServiceStub().testAsyncDualChanel();
    }
}
