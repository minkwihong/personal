package com.ksign.access.restService.service.impl;

import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.service.RsApiTemplateRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * tray 로 conf 내용 내려주는 클래스
 * Created by mkh on 2017-03-07.
 */
@Service("trayConfInfoSetService")
@Scope("prototype")
public class TrayConfInfoSetService extends RsApiTemplateRequest {

    public TrayConfInfoSetService(){};

    public TrayConfInfoSetService(Map<String, Object> reqData) {super(reqData);}

    @Value("#{config['conf.liveCheckInterval']}")
    private  String liveCheckInterval ;

    @Value("#{config['conf.emergencyInterval']}")
    private  String emergencyInterval ;

    @Value("#{config['conf.duplicateCheckInterval']}")
    private  String duplicateCheckInterval ;

    @Value("#{config['conf.trayTimeout']}")
    private  String trayTimeout ;

    @Override
    public void requestParamValidation() throws RequestParamException {

    }

    @Override
    public void validationService() throws ServiceException {

    }

    @Override
    public void postValidationService() {
        log.info("================ postValidationService TrayConfInfoSetService start ======================");

        String result = "LiveCheckInterval=" + liveCheckInterval + "$" +
                "EmergencyInterval=" + emergencyInterval + "$" +
                "DuplicateCheckInterval=" + duplicateCheckInterval + "$" +
                "TrayTimeout=" + trayTimeout + "$";

        log.debug("trayConfigSet ==> " + result);

        RsResultObject.setResultBody(result);
    }

    @Override
    public void paramSet() {}
}
