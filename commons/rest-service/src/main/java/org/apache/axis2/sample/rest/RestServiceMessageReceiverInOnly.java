

/**
 * RestServiceMessageReceiverInOnly.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v1  Built on : Sep 30, 2010 (09:30:50 IST)
 */
        package org.apache.axis2.sample.rest;

        /**
        *  RestServiceMessageReceiverInOnly message receiver
        */

        public class RestServiceMessageReceiverInOnly extends org.apache.axis2.receivers.AbstractInMessageReceiver{

        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext inMessage) throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(inMessage);

        RestServiceSkeleton skel = (RestServiceSkeleton)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = inMessage.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        
            if("add".equals(methodName)){
            
            org.apache.axis2.sample.rest.types.Student wrappedParam = (org.apache.axis2.sample.rest.types.Student)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.apache.axis2.sample.rest.types.Student.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.add(wrappedParam);
                                                } else 
            if("delete".equals(methodName)){
            
            org.apache.axis2.sample.rest.types.StudentName wrappedParam = (org.apache.axis2.sample.rest.types.StudentName)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.apache.axis2.sample.rest.types.StudentName.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.delete(wrappedParam);
                                                } else 
            if("update".equals(methodName)){
            
            org.apache.axis2.sample.rest.types.Student wrappedParam = (org.apache.axis2.sample.rest.types.Student)fromOM(
                                                        inMessage.getEnvelope().getBody().getFirstElement(),
                                                        org.apache.axis2.sample.rest.types.Student.class,
                                                        getEnvelopeNamespaces(inMessage.getEnvelope()));
                                            
                                                     skel.update(wrappedParam);
                                                
                } else {
                  throw new RuntimeException("method not found");
                }
            

        }
        } catch (Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }


        
        //
            private  org.apache.axiom.om.OMElement  toOM(org.apache.axis2.sample.rest.types.Student param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.apache.axis2.sample.rest.types.Student.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(org.apache.axis2.sample.rest.types.StudentName param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(org.apache.axis2.sample.rest.types.StudentName.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, org.apache.axis2.sample.rest.types.Student param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(org.apache.axis2.sample.rest.types.Student.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    
                         private org.apache.axis2.sample.rest.types.Student wrapget(){
                                org.apache.axis2.sample.rest.types.Student wrappedElement = new org.apache.axis2.sample.rest.types.Student();
                                return wrappedElement;
                         }
                    


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  Object fromOM(
        org.apache.axiom.om.OMElement param,
        Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (org.apache.axis2.sample.rest.types.Student.class.equals(type)){
                
                           return org.apache.axis2.sample.rest.types.Student.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.apache.axis2.sample.rest.types.StudentName.class.equals(type)){
                
                           return org.apache.axis2.sample.rest.types.StudentName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.apache.axis2.sample.rest.types.Student.class.equals(type)){
                
                           return org.apache.axis2.sample.rest.types.Student.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.apache.axis2.sample.rest.types.StudentName.class.equals(type)){
                
                           return org.apache.axis2.sample.rest.types.StudentName.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (org.apache.axis2.sample.rest.types.Student.class.equals(type)){
                
                           return org.apache.axis2.sample.rest.types.Student.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    



        /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
        private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
        org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
        returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
        return returnMap;
        }



        }//end of class

    