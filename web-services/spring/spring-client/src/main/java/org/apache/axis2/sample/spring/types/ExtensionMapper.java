
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6-wso2v2  Built on : Oct 02, 2010 (07:33:26 ADT)
 */

        
            package org.apache.axis2.sample.spring.types;
        
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static Object getTypeObject(String namespaceURI,
                                                       String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws Exception{

              
                  if (
                  "http//axis2.apache.org/sample/spring/types".equals(namespaceURI) &&
                  "Employee".equals(typeName)){
                   
                            return  Employee.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http//axis2.apache.org/sample/spring/types".equals(namespaceURI) &&
                  "Project".equals(typeName)){
                   
                            return  Project.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    