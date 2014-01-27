
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: SNAPSHOT  Built on : Aug 07, 2010 (07:59:58 IST)
 */

        
            package org.apache.axis2.sample.rm.types;
        
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static Object getTypeObject(String namespaceURI,
                                                       String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws Exception{

              
                  if (
                  "http//axis2.apache.org/sample/rm/types".equals(namespaceURI) &&
                  "Employee".equals(typeName)){
                   
                            return  Employee.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    