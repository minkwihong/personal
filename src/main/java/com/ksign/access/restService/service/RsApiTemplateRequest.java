package com.ksign.access.restService.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ksign.access.mapper.impl.KARestRepository;
import com.ksign.access.restService.audit.LoginAudit;
import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.RequestUriException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyManager;
import com.ksign.access.tool.GsonDateTypeAdaptor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mkh on 2017-03-02.
 */
public abstract class RsApiTemplateRequest implements RsApiRequest {
    protected Logger log = Logger.getLogger(getClass());

    protected Map<String,Object> reqData;

    protected VerifyManager checkService = null;

    protected StopWatch watcher = null;

    @Autowired
    protected KARestRepository restRepo;

    @Autowired
    protected LoginAudit audit;


    public RsApiTemplateRequest(Map<String,Object> reqData){
        this.reqData = reqData;
        watcher = new StopWatch("serviceTime");

        log.info("request data : " + this.reqData);
    }

    public RsApiTemplateRequest() {}


    @Override
    public void executeService() {
        try {
            watcher.start("service");

            this.destory();
            urlValidation();
            paramSet();
            this.requestParamValidation();
            this.validationService();
            this.postValidationService();

            watcher.stop();
            log.debug("[ Total ServiceTime ] : " + watcher.getTotalTimeSeconds());
        }catch(Exception e){
            if(e instanceof ServiceException) {
                log.error(e);
                reqData.put("resultCode", "F");
                audit.registLoginAudit(reqData);
            } else if(e instanceof RequestUriException){
                log.error(e);
                reqData.put("resultCode", "F");
                audit.registLoginAudit(reqData);
            } else {
                log.error(e);
                RsResultObject.setResultCd(RsResultType.UNKNOWABLE_ERROR.getCode());
                RsResultObject.setResultMsg(RsResultType.UNKNOWABLE_ERROR.getMsg());
                reqData.put("resultCode", "F");
                audit.registLoginAudit(reqData);
            }
        }


    }

    public abstract void paramSet();

    public void urlValidation() throws RequestUriException {

        int cnt = restRepo.selectKAAuthUriList(reqData);

        if(cnt < 1){
            RsResultObject.setResultCd(RsResultType.URI_EXTENDS_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.URI_EXTENDS_ERROR.getMsg());

            throw new RequestUriException(RsResultType.URI_EXTENDS_ERROR.getMsg());
        };
    }

    @Override
    public String getApiResult() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new GsonDateTypeAdaptor());
        Gson gson = gsonBuilder.create();

        return gson.toJson(RsResultObject.result());
    }

    @Override
    public void destory() {
        RsResultObject.destory();
    }

}
