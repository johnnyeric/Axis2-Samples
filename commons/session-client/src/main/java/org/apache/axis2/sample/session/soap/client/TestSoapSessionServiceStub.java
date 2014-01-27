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

package org.apache.axis2.sample.session.soap.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;

public class TestSoapSessionServiceStub {

    public static void main(String[] args) {
        try {
            SoapSessionServiceStub stub1 =
                    new SoapSessionServiceStub("http://localhost:9763/services/SoapSessionService.SoapSessionServiceHttpSoap12Endpoint/");
            stub1._getServiceClient().engageModule("addressing");
            stub1._getServiceClient().getOptions().setManageSession(true);
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                System.out.println("Count ==> " + stub1.getCount());
            }

            try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            // get the reference

            SoapSessionServiceStub stub2 = new SoapSessionServiceStub();

            EndpointReference endpointReference = new EndpointReference("http://localhost:9764/services/SoapSessionService.SoapSessionServiceHttpSoap12Endpoint/");
            stub2._getServiceClient().setTargetEPR(endpointReference);
            stub2._getServiceClient().getTargetEPR().setReferenceParameters(stub1._getServiceClient().getTargetEPR().getAllReferenceParameters());

            stub2._getServiceClient().engageModule("addressing");
            stub2._getServiceClient().getOptions().setManageSession(true);
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                System.out.println("Count ==> " + stub2.getCount());
            }


        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }
}
