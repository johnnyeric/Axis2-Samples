/**
 * RestServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: SNAPSHOT  Built on : Aug 07, 2010 (07:59:55 IST)
 */
package org.apache.axis2.sample.rest;

/**
 * RestServiceSkeleton java skeleton for the axisService
 */
public class RestServiceSkeleton {

    /**
     * Auto generated method signature
     *
     * @param student
     */

    public void add(org.apache.axis2.sample.rest.types.Student student) {
        StudentStore.getInstance().add(student);
    }


    /**
     * Auto generated method signature
     *
     * @param studentName
     */

    public void delete(org.apache.axis2.sample.rest.types.StudentName studentName) {
        StudentStore.getInstance().delete(studentName.getName());
    }


    /**
     * Auto generated method signature
     *
     * @param student0
     */

    public void update(org.apache.axis2.sample.rest.types.Student student0) {
        StudentStore.getInstance().update(student0);
    }


    /**
     * Auto generated method signature
     *
     * @param studentName1
     */

    public org.apache.axis2.sample.rest.types.Student get(
            org.apache.axis2.sample.rest.types.StudentName studentName1) {
        return StudentStore.getInstance().get(studentName1.getName());
    }

}
    