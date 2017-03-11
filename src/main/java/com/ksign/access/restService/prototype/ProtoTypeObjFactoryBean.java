package com.ksign.access.restService.prototype;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

/**
 * Created by mkh on 2017-03-10.
 */

public class ProtoTypeObjFactoryBean {

    private ObjectFactory beanFactory;

    public void setBeanFactory(ObjectFactory beanFactory){
        this.beanFactory = beanFactory;
    }

    public Object getBean(){
        return (Object)beanFactory.getObject();
    }

}
