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

package org.apache.axis2.sample.session.service;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.service.Lifecycle;

public class SessionService implements Lifecycle {

    public static final String COUNT = "count";

    public void init(ServiceContext serviceContext) {
        System.out.println("Initializing the service context for service "
                + serviceContext.getAxisService().getName());
        // initialize the count to zero
        if (serviceContext.getProperty(COUNT) == null){
            serviceContext.setProperty(COUNT, new TestPOJO());
        }
        
    }

    public void destroy(ServiceContext serviceContext) {
        System.out.println("Destroying the service context "
                + serviceContext.getAxisService().getName());
    }

    public int getCount() {
        ServiceContext serviceContext =
                MessageContext.getCurrentMessageContext().getServiceContext();
        TestPOJO storedVaue = (TestPOJO) serviceContext.getProperty(COUNT);
        System.out.println(" ------------- curent value " + storedVaue.getNumber() + " ------------------ ");
        storedVaue.incrementNumber();
        return storedVaue.getNumber();
    }
}
