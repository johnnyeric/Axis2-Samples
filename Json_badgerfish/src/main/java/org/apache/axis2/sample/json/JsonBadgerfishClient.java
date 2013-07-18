package org.apache.axis2.sample.json;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JsonBadgerfishClient {

    private static String backendUrl = "http://localhost:8080/axis2/services/OMWebService";
    String echoOM = "{\"echoOM\":{\"@xmlns\":{\"ns4\":\"http//axis2.apache.org/sample/json/badgerfish/xsd\"},\"appName\":{\"$\":\"1\"}, \"locName\":{\"$\":\"2\"}, \"processId\":{\"$\":\"3\"}}}";
    String printJson = "{\"getJsonString\":{\"appName\":{\"$\":\"1\"}, \"locName\":{\"$\":\"2\"}, \"processId\":{\"$\":\"3\"}}";
    HttpClient httpclient = new DefaultHttpClient();


    public String sendEchoOMRequest() throws IOException {

        HttpPost post = new HttpPost(backendUrl);
        post.setHeader("Content-type", "text/javascript");
        HttpEntity content = new StringEntity(echoOM);

        post.setEntity(content);
        HttpResponse postResponse = httpclient.execute(post);


        System.out.println(postResponse.getStatusLine().getStatusCode());
        String responseMsg = IOUtils.toString(postResponse.getEntity().getContent());
        System.out.println(responseMsg);
        return responseMsg;

          /* HttpGet httpget = new HttpGet(backendUrl+"?"+ data);
        httpget.setHeader("Content-type", "application/json/badgerfish");
        HttpResponse httpResponse = httpclient.execute(httpget);

           HttpPost post = new HttpPost(myURL4);
        post.setHeader("Content-type", "application/json/badgerfish");
        HttpEntity content = new StringEntity(data);

        post.setEntity(content);
        HttpResponse postResponse = httpclient.execute(post);
        System.out.println(postResponse.getStatusLine().getStatusCode());
        System.out.println(IOUtils.toString(postResponse.getEntity().getContent()));*/
    }

    public void printJsonStringRequest() throws IOException {
        HttpPost post = new HttpPost(backendUrl);
        post.setHeader("Content-type", "text/javascript");
        HttpEntity content = new StringEntity(printJson);

        post.setEntity(content);
        HttpResponse postResponse = httpclient.execute(post);
        System.out.println(postResponse.getStatusLine().getStatusCode());
    }
}
