package com.ksign.access.restService.verify.impl;

import com.ksign.access.restService.connect.HttpRsClient;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.verify.VerifyTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 중복로그인 검증 클래스
 * Created by mkh on 2017-03-03.
 */
@Service("dupLoginVerify")
@Scope("prototype")
public class DupLoginVerify extends VerifyTemplate {

    public DupLoginVerify (Map<String,Object> reqMap){
        super(reqMap);
    }
    public DupLoginVerify (){}
    private String trayData = null;
    private String beforeIp = null;
    private String reqIp = null;
    private Map<String,Object> beforeUserMap;

    @Value("#{config['http.port']}")
    private String port;

    @Value("#{config['http.target']}")
    private String target;

    @Override
    public void doVerify() throws ServiceException {
        log.info("============================ dupLoginVerify start =======================-");

        Map<String,Object> result = restRepo.selectDuplLoginUser(reqMap);

        reqIp = (String)reqMap.get("loginIp");

        if(result != null){
            beforeIp = (String)result.get("LOGINIP");

            if(result.size() > 0 ){
                if(!beforeIp.equals(reqIp)){
                    log.info("=============== dupl tray connection start===========");

                    trayData = getTrayReqData(reqMap);
                    HttpRsClient http = new HttpRsClient(beforeIp,port);
                    http.targetCall(target,trayData);
                    String obj = (String) http.getResData();

                    log.debug("tray result ==>: " + obj.toString());

                    if("OK$".equals(obj)){
                        beforeUserMap = reqMap;
                        beforeUserMap.put("loginIp",beforeIp);
                        restRepo.deleteCurrLoginUser(beforeUserMap);
                        beforeUserMap.put("resultCode","T");
                        beforeUserMap.put("eventCode","SE09"); // 예외적 중복로그인으로 인한 로그아웃
                        audit.registLoginAudit(beforeUserMap);
                    }
                }
            }
        }


    }

    public String getTrayReqData( Map<String, Object> map ) {
        String del = "&";
        StringBuffer sb = new StringBuffer();

        sb.append("uid=");
        sb.append(map.get("userId"));
        sb.append(del);
        sb.append("client_ip=");
        sb.append(map.get("loginIp"));
        sb.append(del);
        sb.append("bankCd=");
        sb.append(map.get("bankCd"));

        ;log.info("dupTrayReqData ==> " + sb.toString());

        return sb.toString();
    }
}
