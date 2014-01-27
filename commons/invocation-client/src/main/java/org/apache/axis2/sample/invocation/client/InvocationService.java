

/**
 * InvocationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.invocation.client;

    /*
     *  InvocationService java interface
     */

    public interface InvocationService {
          

        /**
          * Auto generated method signature
          * 
                    * @param echoEmployee0
                
         */

         
                     public org.apache.axis2.sample.invocation.types.Employee echoEmployee(

                             org.apache.axis2.sample.invocation.types.Employee employee1)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoEmployee0
            
          */
        public void startechoEmployee(

                org.apache.axis2.sample.invocation.types.Employee employee1,

                final InvocationServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    