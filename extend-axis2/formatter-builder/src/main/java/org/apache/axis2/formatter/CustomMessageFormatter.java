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

package org.apache.axis2.formatter;

import org.apache.axis2.transport.MessageFormatter;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.AxisFault;
import org.apache.axiom.om.OMOutputFormat;
import org.apache.axiom.om.OMElement;

import java.io.OutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class CustomMessageFormatter implements MessageFormatter {

    public byte[] getBytes(MessageContext messageContext, OMOutputFormat omOutputFormat) throws AxisFault {
        return new byte[0];
    }

    public void writeTo(MessageContext messageContext, OMOutputFormat omOutputFormat, OutputStream outputStream, boolean b) throws AxisFault {
        OMElement topElement = messageContext.getEnvelope().getBody().getFirstElement();

        Iterator iter = topElement.getChildElements();

        OMElement childElement = null;
        String messageToSend = "";
        for (;iter.hasNext();){
            childElement = (OMElement) iter.next();
            messageToSend += childElement.getLocalName() + "," + childElement.getText() + "\n";
        }

        messageToSend = messageToSend.substring(0, messageToSend.lastIndexOf("\n"));
        try {
            outputStream.write(messageToSend.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new AxisFault("Can not write the message to out stream");
        }

    }

    public String getContentType(MessageContext messageContext, OMOutputFormat omOutputFormat, String s) {
        return "application/custom";
    }

    public URL getTargetAddress(MessageContext messageContext, OMOutputFormat omOutputFormat, URL url) throws AxisFault {
        return url;
    }

    public String formatSOAPAction(MessageContext messageContext, OMOutputFormat omOutputFormat, String s) {
        return null;
    }
}
