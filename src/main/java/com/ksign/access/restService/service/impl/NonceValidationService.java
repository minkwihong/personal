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
 * Nonce 유효성 검증 클래스
 * Created by mkh on 2017-03-07.
 */

@Service("nonceValidationService")
@Scope("prototype")
public class NonceValidationService extends RsApiTemplateRequest {

    public NonceValidationService(){};
    public NonceValidationService(Map<String, Object> reqData) {super(reqData);}

    @Override
    public void requestParamValidation() throws RequestParamException {
        log.info("================ nonceValidationService requestParamValidation start ======================");

        if(reqData.get("nonce") == null || reqData.get("nonce").equals("")){
            throw new RequestParamException("param error");
        }
    }

    @Override
    public void validationService() throws ServiceException {
        log.info("================ nonceValidationService validationService start ======================");
        List<String> beanList = new ArrayList<String>();

        beanList.add("nonceVerify");

        checkService = new VerifyManager(beanList,reqData);
        checkService.doVerify();
    }

    @Override
    public void postValidationService() {
        log.info("================ nonceValidationService postValidationService start ======================");

        RsResultObject.setResultCd(RsResultType.AUTH_SUCCESS.getCode());
        RsResultObject.setResultMsg(RsResultType.AUTH_SUCCESS.getMsg());

    }

    @Override
    public void paramSet() {
        reqData.put("auditType", RsServiceType.NONCEVALIDATIONSERVICE.getClientType());
        reqData.put("eventCode", RsServiceType.NONCEVALIDATIONSERVICE.getEventType());
    }
}
