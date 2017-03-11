package com.ksign.access;


import com.ksign.access.restService.connect.HttpRsClient;

/**
 * Created by mkh on 2017-03-08.
 */
public class TestMain2 {
    public static void main(String[] args) {
        String host = "server.min.com";
        String port = "19091";
        String target = "/cs-duplicate.jsp";
        String postData = "uid=" + "bin" + "&client_ip=" + "127.0.0.1";

        HttpRsClient http = new HttpRsClient(host,port);
        http.targetCall(target,postData);

        Object resObj =  http.getResData();
        System.out.println(resObj.toString());

    }
}
