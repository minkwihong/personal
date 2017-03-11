package com.ksign.access.restService.response;

import java.util.HashMap;

/**
 * Created by mkh on 2017-03-02.
 */
public class RsResultObject {
    public static String resultCd = "";
    public static String resultMsg = "";
    public static String resultBody = "";

    public String getResultCd() {
        return resultCd;
    }

    public static void setResultCd(String resultCd) {
        RsResultObject.resultCd = resultCd;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public static void setResultMsg(String resultMsg) {
        RsResultObject.resultMsg = resultMsg;}

    public static String getResultBody() {
        return resultBody;
    }
    public static void setResultBody(String resultBody) {
        RsResultObject.resultBody = resultBody;
    }

    public static HashMap<String,Object> result(){
        HashMap<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("resultCd",resultCd);
        resultMap.put("resultMsg",resultMsg);
        resultMap.put("resultBody",resultBody);

        return resultMap;
    }

    public static void destory(){
        resultCd = "";
        resultMsg = "";
        resultBody = "";
    }
}
