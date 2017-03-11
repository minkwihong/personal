package com.ksign.access.controller;


import com.ksign.access.restService.service.RsApiRequest;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.service.RsServiceDispacher;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mkh on 2017-03-02.
 */
@RestController
@RequestMapping("/ssoRest")
public class RsApiController {
    private Logger log = Logger.getLogger(getClass());
    private String lhead = "[REST-API] ";


    @RequestMapping(value="api/{serviceId}", produces="application/json;charset=UTF-8")
    public Object restApiControl(@PathVariable("serviceId") String serviceId,
                             HttpServletRequest req, HttpServletResponse resp,
                             @RequestBody(required = false) String reqJson

    )  {
        log.info(" ============================ restful service start ===============================");
        if(log.isDebugEnabled()) log.debug(lhead + ",serviceId: " + serviceId);

        RsApiRequest serviceRequest = null;

        try{
            serviceRequest = RsServiceDispacher.dispatch(reqJson, serviceId, req);
            serviceRequest.executeService();

        }catch(Exception e){
            e.printStackTrace();
            reqJson = null;

            return serviceRequest.getApiResult();
        }

        return serviceRequest.getApiResult();
    }

    @RequestMapping(value="tray/{serviceId}", produces= "text/plain;charset=utf-8")
    public String restTrayApiControl(@PathVariable("serviceId") String serviceId,
                                 HttpServletRequest req, HttpServletResponse resp,
                                 @RequestBody(required = false) String reqJson

    )  {
        log.info(" ============================ trayRestful service start ===============================");
        if(log.isDebugEnabled()) log.debug(lhead + ",serviceId: " + serviceId);

        RsApiRequest serviceRequest = null;

        try{
            serviceRequest = RsServiceDispacher.dispatch(reqJson, serviceId, req);
            serviceRequest.executeService();

        }catch(Exception e){
            e.printStackTrace();
            reqJson = null;

            return serviceRequest.getApiResult();
        }

        return RsResultObject.getResultBody();
    }
}
