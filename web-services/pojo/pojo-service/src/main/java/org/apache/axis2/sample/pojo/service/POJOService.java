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

package org.apache.axis2.sample.pojo.service;

import org.apache.axis2.sample.pojo.types.Project;

public class POJOService {
    
    public String echoString(String string){
        return string;
    }

    public Project echoProject(Project project){
        return project;
    }

    public void restart(){
        System.out.println("server restarting");
    }

    public void inOnlyString(String str) {
        System.out.println(str);
    }

    public void inOnly(String str, int i) {
        System.out.println("String : " + str + "   INT :" + i);
    }

}
