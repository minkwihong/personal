package com.ksign.access.restService.verify.impl;

import com.ksign.access.mapper.impl.KAPwPolicyRepository;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by mkh on 2017-03-10.
 */
@Service("passwordUpdateVerify")
@Scope("prototype")
public class PasswordUpdateVerify extends VerifyTemplate {

    public PasswordUpdateVerify(){};
    public PasswordUpdateVerify(Map<String,Object> reqMap){
        super(reqMap);
    }

    @Autowired
    private KAPwPolicyRepository pwRepo;

    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ PasswordUpdateVerify start =======================-");


    }
}
