package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.response.RsResultType;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by mkh on 2017-03-08.
 */
@Service("userVerify")
@Scope("prototype")
public class UserVerify extends VerifyTemplate {

    public UserVerify (Map<String,Object> reqMap){
        super(reqMap);
    }
    public UserVerify (){}

    int count = 0;

    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ UserVerify start =======================-");

        count = restRepo.selectKAUserInfoCnt(reqMap);

        if(count > 0){
            RsResultObject.setResultCd(RsResultType.EXISTUSER_ERROR.getCode());
            RsResultObject.setResultMsg(RsResultType.EXISTUSER_ERROR.getMsg());

            throw new ServiceException(RsResultType.EXISTUSER_ERROR.getMsg());
        }
    }
}
