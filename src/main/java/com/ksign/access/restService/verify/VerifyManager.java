package com.ksign.access.restService.verify;

import com.ksign.access.mapper.impl.KARestRepository;
import com.ksign.access.restService.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mkh on 2017-03-02.
 */
@Component
public class VerifyManager {
    protected Logger log = Logger.getLogger(getClass());

    @Autowired
    KARestRepository restRepo;

    private static ApplicationContext springContext;

    @Autowired
    public void init(ApplicationContext springContext){
        this.springContext = springContext;
    }

    List<String> beanList = new ArrayList<String>();

    Map<String,Object> reqMap = null;

    public VerifyManager(List<String> beanList, Map<String,Object> reqMap){
        this.beanList = beanList;
        this.reqMap = reqMap;
    };

    public VerifyManager(){};



    public List<String> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<String> beanList) {
        this.beanList = beanList;
    }

    public void doVerify() throws ServiceException {
        log.debug("beanList : " + beanList.toString());

        for(String service : beanList){
            Verify valObj = (Verify) springContext.getBean(service,reqMap);
            valObj.doVerify();
        }
    }

    public void destroy(){
        if(beanList.size() > 0) beanList.clear();
    }
}
