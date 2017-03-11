package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *  패스워드 유효성 검증 클래스
 * Created by mkh on 2017-03-03.
 */
@Service("passwordVerify")
@Scope("prototype")
public class PasswordVerify extends VerifyTemplate {

    @Override
    public void doVerify() {
        log.info("============================ PasswordVerify start =======================-");
    }
}
