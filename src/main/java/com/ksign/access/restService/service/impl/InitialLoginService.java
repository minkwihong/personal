package com.ksign.access.restService.service.impl;

import com.ksign.access.restService.audit.LoginAudit;
import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsServiceType;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyManager;
import com.ksign.access.restService.service.RsApiTemplateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 최초사용자 등록 서비스 클래스
 * Created by mkh on 2017-03-06.
 */
@Service("initialLoginService")
@Scope("prototype")
public class InitialLoginService extends RsApiTemplateRequest {

    public InitialLoginService(){};
    public InitialLoginService(Map<String, Object> reqData) {super(reqData);}

    @Autowired
    public LoginAudit audit;

    @Override
    public void requestParamValidation() throws RequestParamException {

    }

    @Override
    public void validationService() throws ServiceException{
        log.info("================ InitialLoginService validationService start ======================");
        List<String> beanList = new ArrayList<String>();

        beanList.add("userVerify");

        checkService = new VerifyManager(beanList,reqData);
        checkService.doVerify();
    }

    @Override
    public void postValidationService() {
        log.info("================ InitialLoginService postValidationService start ======================");

        restRepo.insertKAUserInfo(reqData);

        RsResultObject.setResultCd(RsResultType.AUTH_SUCCESS.getCode());
        RsResultObject.setResultMsg(RsResultType.AUTH_SUCCESS.getMsg());

    }

    @Override
    public void paramSet() {
        reqData.put("auditType", RsServiceType.INITIALLOGINSERVICE.getClientType());
        reqData.put("eventCode", RsServiceType.INITIALLOGINSERVICE.getEventType());
    }
}
