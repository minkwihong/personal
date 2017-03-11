package com.ksign.access.restService.audit;

import com.ksign.access.mapper.impl.KARestRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by mkh on 2017-03-04.
 */
@Service("loginAudit")
public class LoginAudit {

    public static ApplicationContext springContext;

    private Logger log = Logger.getLogger(getClass());

    @Autowired
    private KARestRepository restRepo;

    private Map<String,Object> reqMap = null;

    public LoginAudit(){}

    public LoginAudit(Map<String,Object> reqMap){
        this.reqMap = reqMap;
    }

    public void registLoginAudit(Map<String,Object> reqMap){
        log.info("======================= loginAudit start =================================");

        int count = restRepo.currLoginAuditRow();

        reqMap.put("auditOid",count + 1);
        restRepo.insertLoginAudit(reqMap);
    }
}
