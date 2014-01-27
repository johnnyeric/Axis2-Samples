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

package org.apache.axis2.sample.mtom.client;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axiom.attachments.ByteArrayDataSource;

import javax.activation.DataHandler;

public class TestMTOMServiceStub {

    public static void main(String[] args) {
        try {
            MTOMServiceStub stub =  new MTOMServiceStub(
                 "http://localhost:8088/axis2/services/MTOMService.MTOMServiceHttpSoap12Endpoint/");
            String messageToSend = "Test message for binary data";
            DataHandler dataHandler = null;
            dataHandler = new DataHandler(new ByteArrayDataSource(messageToSend.getBytes()));

            //first send it as base 64 binary
            stub.getBinaryData(dataHandler);

            //use mtome
            stub._getServiceClient().getOptions().setProperty(
                    Constants.Configuration.ENABLE_MTOM, Constants.VALUE_TRUE);
            dataHandler = new DataHandler(new ByteArrayDataSource(messageToSend.getBytes()));
            stub.getBinaryData(dataHandler);

        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (java.rmi.RemoteException e) {
            e.printStackTrace();
        }
    }
}
