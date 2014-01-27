

/**
 * SampleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.wsdl.client;

    /*
     *  SampleService java interface
     */

    public interface SampleService {
          

        /**
          * Auto generated method signature
          * 
                    * @param echoString3
                
         */

         
                     public String echoString(

                             String param4)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoString3
            
          */
        public void startechoString(

                String param4,

                final SampleServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param echoProject7
                
         */

         
                     public org.apache.axis2.sample.wsdl.types.Project echoProject(

                             org.apache.axis2.sample.wsdl.types.Project param8)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoProject7
            
          */
        public void startechoProject(

                org.apache.axis2.sample.wsdl.types.Project param8,

                final SampleServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    