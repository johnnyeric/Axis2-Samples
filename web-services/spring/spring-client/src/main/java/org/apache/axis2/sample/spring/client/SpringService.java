

/**
 * SpringService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.spring.client;

    /*
     *  SpringService java interface
     */

    public interface SpringService {
          

        /**
          * Auto generated method signature
          * 
                    * @param echoString4
                
         */

         
                     public String echoString(

                             String string5)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoString4
            
          */
        public void startechoString(

                String string5,

                final SpringServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
         */

         
                     public org.apache.axis2.sample.spring.types.Project getProject(

                     )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
          */
        public void startgetProject(


                final SpringServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  setProject(
                org.apache.axis2.sample.spring.types.Project project12

        ) throws java.rmi.RemoteException
        
        ;

        

        /**
          * Auto generated method signature
          * 
                    * @param echoProject13
                
         */

         
                     public org.apache.axis2.sample.spring.types.Project echoProject(

                             org.apache.axis2.sample.spring.types.Project project14)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param echoProject13
            
          */
        public void startechoProject(

                org.apache.axis2.sample.spring.types.Project project14,

                final SpringServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    