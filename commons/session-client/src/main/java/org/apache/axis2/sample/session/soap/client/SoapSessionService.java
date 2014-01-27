

/**
 * SoapSessionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.session.soap.client;

    /*
     *  SoapSessionService java interface
     */

    public interface SoapSessionService {
          

        /**
          * Auto generated method signature
          * 
         */

         
                     public int getCount(

                     )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
          */
        public void startgetCount(


                final org.apache.axis2.sample.session.soap.client.SoapSessionServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    