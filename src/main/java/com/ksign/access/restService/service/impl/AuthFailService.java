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
 * ID/PW 인증실패후 서비스 클랙스
 * Created by mkh on 2017-03-04.
 */
@Service("authFailService")
@Scope("prototype")
public class AuthFailService extends RsApiTemplateRequest {

    private int failCnt = 0;

    public AuthFailService(){};

    public AuthFailService(Map<String, Object> reqData) {super(reqData);}

    @Override
    public void requestParamValidation() throws RequestParamException {

    }

    @Override
    public void validationService() throws ServiceException {
        log.info("================ AuthFailService validationService start ======================");

        List<String> beanList = new ArrayList<String>();

        beanList.add("loginFailVerify");

        checkService = new VerifyManager(beanList,reqData);
        checkService.doVerify();
    }

    @Override
    public void postValidationService() {
        log.info("================ AuthFailService postValidationService start ======================");

        failCnt = restRepo.selectAccountFailCnt(reqData);

        if(failCnt >=5){
            reqData.put("activation","N");
            restRepo.updateAccountActivation(reqData);
        }

        reqData.put("resultCode","T");
        audit.registLoginAudit(reqData);

        RsResultObject.setResultCd(RsResultType.AUTH_SUCCESS.getCode());
        RsResultObject.setResultMsg(RsResultType.AUTH_SUCCESS.getMsg());

    }



    @Override
    public void paramSet() {
        reqData.put("auditType", RsServiceType.AUTHFAILSERVICE.getClientType());
        reqData.put("eventCode", RsServiceType.AUTHFAILSERVICE.getEventType());
    }
}
