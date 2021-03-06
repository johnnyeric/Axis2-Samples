
/**
 * InvocationServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */

    package org.apache.axis2.sample.invocation.client;

    /**
     *  InvocationServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class InvocationServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public InvocationServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public InvocationServiceCallbackHandler(){
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
                    org.apache.axis2.sample.invocation.types.Employee result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from echoEmployee operation
           */
            public void receiveErrorechoEmployee(Exception e) {
            }
                


    }
    