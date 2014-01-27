/*
 * Copyright 2004,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.deployer;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axiom.om.util.StAXUtils;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.deployment.Deployer;
import org.apache.axis2.deployment.DeploymentException;
import org.apache.axis2.deployment.repository.util.DeploymentFileData;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.InOnlyAxisOperation;
import org.apache.axis2.description.InOutAxisOperation;
import org.apache.axis2.AxisFault;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.namespace.QName;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import sample.deployer.service.SampleInOnlyMessageReceiver;
import sample.deployer.service.SampleInOutMessageReceiver;


public class SampleDeployer implements Deployer {

    private ConfigurationContext configurationContext;
    private String serviceName;

    public void init(ConfigurationContext configurationContext) {
        this.configurationContext = configurationContext;
    }

    public void deploy(DeploymentFileData deploymentFileData) throws DeploymentException {
        System.out.println("Deploying the service");
        try {
            XMLStreamReader xmlStreamReader =
                    StAXUtils.createXMLStreamReader(new FileInputStream(deploymentFileData.getFile()));
            OMElement omElement = new StAXOMBuilder(xmlStreamReader).getDocumentElement();
            this.serviceName = omElement.getAttributeValue(new QName("", "name"));
            AxisService axisServce = new AxisService(this.serviceName);
            OMElement operationElement = null;
            String type = null;
            AxisOperation axisOperation;
            for (Iterator iter = omElement.getChildElements(); iter.hasNext();) {
                operationElement = (OMElement) iter.next();
                type = operationElement.getAttributeValue(new QName("", "type"));
                if (type.equals("inOnly")) {
                    axisOperation =
                            new InOnlyAxisOperation(new QName("", operationElement.getAttributeValue(new QName("", "name"))));
                    axisOperation.setMessageReceiver(new SampleInOnlyMessageReceiver());
                } else {
                    axisOperation =
                            new InOutAxisOperation(new QName("", operationElement.getAttributeValue(new QName("", "name"))));
                    axisOperation.setMessageReceiver(new SampleInOutMessageReceiver());
                }
                axisOperation.setSoapAction(operationElement.getAttributeValue(new QName("", "action")));
                axisServce.addOperation(axisOperation);
            }
            this.configurationContext.getAxisConfiguration().addService(axisServce);

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public void setDirectory(String string) {

    }

    public void setExtension(String string) {

    }

    public void unDeploy(String s) throws DeploymentException {
        System.out.println("Undeploy the service");
        try {
            this.configurationContext.getAxisConfiguration().removeService(this.serviceName);
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
    }

    public void cleanup() throws DeploymentException {

    }

}
