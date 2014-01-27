

/**
 * POJOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.pojo.client;

    /*
     *  POJOService java interface
     */

    public interface POJOService {
          

        /**
          * Auto generated method signature
          * 
                    * @param echoProject1
                
         */

         
                     public org.apache.axis2.sample.pojo.types.Project echoProject(

                             org.apache.axis2.sample.pojo.types.Project project2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoProject1
            
          */
        public void startechoProject(

                org.apache.axis2.sample.pojo.types.Project project2,

                final org.apache.axis2.sample.pojo.client.POJOServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param echoString5
                
         */

         
                     public String echoString(

                             String string6)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoString5
            
          */
        public void startechoString(

                String string6,

                final org.apache.axis2.sample.pojo.client.POJOServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    