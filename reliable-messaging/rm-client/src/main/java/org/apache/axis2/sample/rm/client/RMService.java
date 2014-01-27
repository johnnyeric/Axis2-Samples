

/**
 * RMService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: SNAPSHOT  Built on : Aug 07, 2010 (07:59:55 IST)
 */

    package org.apache.axis2.sample.rm.client;

    /*
     *  RMService java interface
     */

    public interface RMService {
          

        /**
          * Auto generated method signature
          * 
                    * @param echoEmployee1
                
         */

         
                     public org.apache.axis2.sample.rm.types.Employee echoEmployee(

                             org.apache.axis2.sample.rm.types.Employee employee2)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoEmployee1
            
          */
        public void startechoEmployee(

                org.apache.axis2.sample.rm.types.Employee employee2,

                final RMServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  setEmployee(
                org.apache.axis2.sample.rm.types.Employee employee6

        ) throws java.rmi.RemoteException
        
        ;

        

        
       //
       }
    