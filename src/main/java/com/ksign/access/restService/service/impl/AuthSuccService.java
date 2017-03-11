package com.ksign.access.restService.service.impl;

import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsServiceType;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyManager;
import com.ksign.access.restService.service.RsApiTemplateRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ID/PW 인증 성공후 서비스 클래스
 * Created by mkh on 2017-03-02.
 */
@Service("authSuccService")
@Scope("prototype")
public class AuthSuccService extends RsApiTemplateRequest {
    public AuthSuccService(){};

    public AuthSuccService(Map<String, Object> reqData) {super(reqData);}


    @Override
    public void requestParamValidation() throws RequestParamException {
        log.info("=========== requestParamValidation ===================");

        if(reqData.get("userId") == null || reqData.get("userId").equals("")){
            RsResultObject.setResultCd(RsResultType.PARAM_NOT_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.PARAM_NOT_ERROR.getMsg());

            throw new RequestParamException(RsResultType.PARAM_NOT_ERROR.getMsg());
        }else if(reqData.get("bankCd") == null || reqData.get("bankCd").equals("")){
            RsResultObject.setResultCd(RsResultType.PARAM_NOT_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.PARAM_NOT_ERROR.getMsg());

            throw new RequestParamException(RsResultType.PARAM_NOT_ERROR.getMsg());
        }
    }

    @Override
    public void validationService() throws ServiceException {
        log.info("================ AuthSuccService validationService start ======================");
        List<String> beanList = new ArrayList<String>();

        beanList.add("accountVerify");
        beanList.add("dupLoginVerify");

        checkService = new VerifyManager(beanList,reqData);
        checkService.doVerify();
    }

    @Override
    public void postValidationService() {
        log.info("================ AuthSuccService postValidationService start ======================");

        reqData.put("failCnt",0);
        restRepo.insertAccoutFailCnt(reqData);

        RsResultObject.setResultCd(RsResultType.AUTH_SUCCESS.getCode());
        RsResultObject.setResultMsg(RsResultType.AUTH_SUCCESS.getMsg());

    }

    @Override
    public void paramSet() {
        reqData.put("auditType", RsServiceType.AUTHSUCCSERVICE.getClientType());
        reqData.put("eventCode", RsServiceType.AUTHSUCCSERVICE.getEventType());
    }
}
