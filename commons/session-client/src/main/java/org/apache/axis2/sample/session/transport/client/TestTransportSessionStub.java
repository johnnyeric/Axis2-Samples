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

package org.apache.axis2.sample.session.transport.client;

import org.apache.axis2.AxisFault;

public class TestTransportSessionStub {

    public static void main(String[] args) {
          try {
            TransportSessionServiceStub stub =
                    new TransportSessionServiceStub(
                            "http://localhost:8088/axis2/services/TransportSessionService.TransportSessionServiceHttpSoap12Endpoint/");
            stub._getServiceClient().getOptions().setManageSession(true);
            for (int i = 0; i < 3; i++) {
               System.out.println("Count ==> " +  stub.getCount());
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }
}
