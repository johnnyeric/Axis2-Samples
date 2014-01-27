

/**
 * RestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.rest;

    /*
     *  RestService java interface
     */

    public interface RestService {
          
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  add(
                org.apache.axis2.sample.rest.types.Student student3

        ) throws java.rmi.RemoteException
        
        ;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  delete(
                org.apache.axis2.sample.rest.types.StudentName studentName4

        ) throws java.rmi.RemoteException
        
        ;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  update(
                org.apache.axis2.sample.rest.types.Student student5

        ) throws java.rmi.RemoteException
        
        ;

        

        /**
          * Auto generated method signature
          * 
                    * @param studentName6
                
         */

         
                     public org.apache.axis2.sample.rest.types.Student get(

                             org.apache.axis2.sample.rest.types.StudentName studentName6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param studentName6
            
          */
        public void startget(

                org.apache.axis2.sample.rest.types.StudentName studentName6,

                final RestServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    