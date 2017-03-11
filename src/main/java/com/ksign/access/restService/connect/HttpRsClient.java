package com.ksign.access.restService.connect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkh on 2017-03-08.
 */
public class HttpRsClient {
    private String ip;
    private String port;
    private RestTemplate rest;
    private String resource;
    private String prefix = "http://";
    private String resObj = null;
    private Object reqObj = null;

    @Value("#{config['http.connTimeout']}")
    private int connTimeout;

    @Value("#{config['http.readTimeout']}")
    private int readTimeout;

    public HttpRsClient(){};

    public HttpRsClient(String ip, String port){
        this.ip = ip;
        this.port = port;
        restHelper();
    };

    public void restHelper() {
        SimpleClientHttpRequestFactory reqFactory = new SimpleClientHttpRequestFactory();
        reqFactory.setConnectTimeout(connTimeout);
        reqFactory.setReadTimeout(readTimeout);

        rest = new RestTemplate(reqFactory);
        List<HttpMessageConverter<?>> convList = new ArrayList<HttpMessageConverter<?>>();
        convList.add(new StringHttpMessageConverter());
        rest.setMessageConverters(convList);
    }



    public void targetCall(String resource ,Object reqObj) {
        this.resource = resource;
        this.reqObj = reqObj;
        String url = this.prefix + this.ip + ":" + this.port + this.resource;
        String respData = rest.postForObject(url,reqObj,String.class);
        this.resObj = respData;
    }

    public void destory() {

    }

    public Object getResData() {
        return resObj;
    }
}
