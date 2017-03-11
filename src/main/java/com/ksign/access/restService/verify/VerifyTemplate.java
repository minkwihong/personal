package com.ksign.access.restService.verify;

import com.ksign.access.mapper.impl.KARestRepository;
import com.ksign.access.restService.audit.LoginAudit;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

/**
 * Created by mkh on 2017-03-03.
 */
public abstract class VerifyTemplate implements Verify {

    protected Logger log = Logger.getLogger(getClass());

    protected Map<String,Object> reqMap = null;

    public VerifyTemplate(){};

    @Autowired
    protected KARestRepository restRepo;

    @Autowired
    protected LoginAudit audit;

    public VerifyTemplate(Map<String,Object> reqMap){this.reqMap = reqMap;};

    protected ApplicationContext springContext;

    @Autowired
    public void init(ApplicationContext springContext){
        this.springContext = springContext;
    }





}
