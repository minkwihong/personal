package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * ID/PW 검증 실패시 로그인 실패카운트 검증 클래스
 * Created by mkh on 2017-03-04.
 */
@Service("loginFailVerify")
@Scope("prototype")
public class LoginFailVerify extends VerifyTemplate {

    private int failCnt = 0;
    public LoginFailVerify(Map<String,Object> reqMap){
        super(reqMap);
    }
    public LoginFailVerify(){}


    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ LoginFailVerify start =======================-");

        Map<String,Object> user = restRepo.selectAccountVerify(reqMap);
        failCnt = restRepo.selectAccountFailCnt(reqMap);

        if ("N".equals(user.get("ACTIVATION"))) {

        }else if(failCnt < 5){
            reqMap.put("failCnt",failCnt+1);
            restRepo.insertAccoutFailCnt(reqMap);
        }
    }
}
