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

import org.apache.axis2.sample.rest.types.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentStore {

    private static StudentStore instance = new StudentStore();

    private Map<String, Student> store;

    private StudentStore(){
        this.store = new HashMap();
    }

    public static StudentStore getInstance(){
        return instance;
    }

    public Student get(String name){
        return this.store.get(name);
    }

    public void add(Student student){
        this.store.put(student.getName(), student);
    }

    public void update(Student student){
        this.store.put(student.getName(), student);
    }

    public void delete(String name){
        this.store.remove(name);
    }
}
