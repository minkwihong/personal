package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 계정 활성/비황성화 검증 클래스
 * Created by mkh on 2017-03-03.
 */
@Service("accountVerify")
@Scope("prototype")
public class AccountVerify extends VerifyTemplate {


    public AccountVerify (Map<String,Object> reqMap){
        super(reqMap);
    }
    public AccountVerify (){}

    public String isActivation = null;

    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ AccountVerify start =======================-");

        Map<String,Object> user = restRepo.selectAccountVerify(reqMap);

        if(user == null){
            RsResultObject.setResultCd(RsResultType.NOT_EXISTUSER_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.NOT_EXISTUSER_ERROR.getMsg());

            throw new ServiceException(RsResultType.NOT_EXISTUSER_ERROR.getMsg());
        }
        if(!"Y".equals(user.get("ACTIVATION"))){
            RsResultObject.setResultCd(RsResultType.ACCOUNT_NOT_ACTIVATION.getCode());
            RsResultObject.setResultMsg(RsResultType.ACCOUNT_NOT_ACTIVATION.getMsg());

            throw new ServiceException(RsResultType.ACCOUNT_NOT_ACTIVATION.getMsg());
        };


    }
}
