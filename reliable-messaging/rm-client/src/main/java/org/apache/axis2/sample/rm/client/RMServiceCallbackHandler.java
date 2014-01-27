
/**
 * RMServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: SNAPSHOT  Built on : Aug 07, 2010 (07:59:55 IST)
 */

    package org.apache.axis2.sample.rm.client;

    /**
     *  RMServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class RMServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public RMServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public RMServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for echoEmployee method
            * override this method for handling normal response from echoEmployee operation
            */
           public void receiveResultechoEmployee(
                    org.apache.axis2.sample.rm.types.Employee result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from echoEmployee operation
           */
            public void receiveErrorechoEmployee(Exception e) {
            }
                
               // No methods generated for meps other than in-out
                


    }
    