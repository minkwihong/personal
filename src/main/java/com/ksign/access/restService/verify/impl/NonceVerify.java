package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * nonce 검증 클래스
 * Created by mkh on 2017-03-07.
 */
@Service("nonceVerify")
@Scope("prototype")
public class NonceVerify extends VerifyTemplate {

    public NonceVerify(Map<String,Object> reqMap){
        super(reqMap);
    }
    public NonceVerify(){}
    private String repoNonce = null;

    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ NonceVerify start =======================-");

        repoNonce = restRepo.selectNonceValidation(reqMap);

        if(!repoNonce.equals(reqMap.get("nonce"))){
            RsResultObject.setResultCd(RsResultType.NONCE_VALIDATION_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.NONCE_VALIDATION_ERROR.getMsg());

            throw new ServiceException(RsResultType.NONCE_VALIDATION_ERROR.getMsg());
        }

    }
}
