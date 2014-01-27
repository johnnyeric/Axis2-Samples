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

package org.apache.axis2.sample.mtom;

import javax.activation.DataHandler;
import java.io.IOException;

public class MTOMService {

    public void getBinaryData(DataHandler dataHandler){
        // write the datahandler contents to system out pur stream
        // in real world this can be written to a file
        try {
            System.out.print("--");
            dataHandler.writeTo(System.out);
            System.out.println("--");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
