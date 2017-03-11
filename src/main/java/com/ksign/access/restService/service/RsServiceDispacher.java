package com.ksign.access.restService.service;

import com.ksign.access.restService.audit.LoginAudit;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.response.RsServiceType;
import com.ksign.access.tool.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mkh on 2017-03-02.
 */

@Component
public class RsServiceDispacher {
    protected Logger log = Logger.getLogger(getClass());

    public static ApplicationContext springContext;

    @Autowired
    static LoginAudit audit;

    @Autowired
    public void init(ApplicationContext springContext){
        this.springContext = springContext;
    }

    private static RsServiceType type = null;
    public RsServiceDispacher() {}
    static Map<String, Object> reqMap = null;




    public static RsApiRequest dispatch(String reqJson, String serviceId, HttpServletRequest req) throws IOException {

        type = RsServiceType.valueOf(serviceId.toUpperCase());

        reqMap = dataSet(serviceId,reqJson,req);

        String beanName = null;
        RsApiRequest service = null;

        switch(type) {
            case AUTHSUCCSERVICE:
                beanName = "authSuccService";
                break;
            case AUTHFAILSERVICE:
                beanName = "authFailService";
                break;
            case NONCEVALIDATIONSERVICE:
                beanName = "nonceValidationService";
                break;
            case TRAYLOGINPOSTSERVICE:
                beanName = "trayEventPostService";
                break;
            case TRAYLOGOUTPOSTSERVICE:
                beanName = "trayAgentInfoSetService";
                break;
            case INITIALLOGINSERVICE:
                beanName = "initialLoginService";
                break;
            case TRAYCONFINFOSERVICE:
                beanName = "trayConfInfoSetService";
                break;
            default:
                beanName = "notFound";
                break;
        }

        try {
            service = (RsApiRequest) springContext.getBean(beanName,reqMap);
        }catch (Exception e){
            e.printStackTrace();
            RsResultObject.setResultCd(RsResultType.UNKNOWABLE_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.UNKNOWABLE_ERROR.getMsg());
            reqMap.put("resultCode", "F");
            audit.registLoginAudit(reqMap);
        }

        return service;

    }

    public static Map<String,Object> dataSet(String serviceId ,String reqJson,HttpServletRequest req) throws IOException {
        Map<String,Object> resultMap = new HashMap<String,Object>();

        if("trayEventPostService".equals(serviceId))resultMap.put("TRAYPARAM",req.getParameter("x"));
        else resultMap = CommonUtil.convertJsonToObject(reqJson);

        resultMap.put("requestUri", CommonUtil.getHostFromUri(req.getRequestURI()));

        return resultMap;
    }




}
