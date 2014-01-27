
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: SNAPSHOT  Built on : Aug 07, 2010 (07:59:58 IST)
 */

        
            package org.apache.axis2.sample.wsdl.types;
        
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static Object getTypeObject(String namespaceURI,
                                                       String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws Exception{

              
                  if (
                  "http//axis2.apache.org/sample/wsdl/types".equals(namespaceURI) &&
                  "employee".equals(typeName)){
                   
                            return  Employee.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http//axis2.apache.org/sample/wsdl/types".equals(namespaceURI) &&
                  "project".equals(typeName)){
                   
                            return  Project.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    