package org.apache.axis2.sample.json;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        JsonBadgerfishClient badgerfishClient = new JsonBadgerfishClient();
//        badgerfishClient.sendEchoOMRequest();

        badgerfishClient.printJsonStringRequest();
    }
}
