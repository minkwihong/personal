package com.ksign.access.restService.service.impl;

import com.ksign.access.restService.config.KAAgentVO;
import com.ksign.access.restService.config.PropAgentInfo;
import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsServiceType;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.service.RsApiTemplateRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * tray에서 로그아웃 처리후 서비스 클래스
 * Created by mkh on 2017-03-04.
 */
@Service("trayAgentInfoSetService")
@Scope("prototype")
public class TrayAgentInfoSetService extends RsApiTemplateRequest {

    public TrayAgentInfoSetService(){};

    public TrayAgentInfoSetService(Map<String, Object> reqData) {super(reqData);}

    @Override
    public void requestParamValidation() throws RequestParamException {
        log.info("=========== requestParamValidation ===================");
    }

    @Override
    public void validationService() throws ServiceException {
        log.info("================ TrayAgentInfoSetService validationService start ======================");
    }

    @Override
    public void postValidationService() {
        log.info("================ TrayAgentInfoSetService postValidationService start ======================");

        StringBuffer sb = new StringBuffer();

        //restRepo.deleteCurrLoginUser(reqData);

        reqData.put("resultCode","T");

        PropAgentInfo conf = PropAgentInfo.getInstance();
        LinkedHashMap agentList = conf.agentList;

        for (Iterator it = agentList.keySet().iterator(); it.hasNext(); ) {
            String gid = (String)it.next();
            KAAgentVO agentInfo = (KAAgentVO)agentList.get(gid);

            String agentUrl = agentInfo.m_logoutUrl;


            String scheme = agentUrl.substring(0, agentUrl.indexOf("//"));
            String next = agentUrl.substring(agentUrl.indexOf("//") + 2);

            String host = next.substring(0, next.indexOf("/"));
            String logoutUri = next.substring(next.indexOf("/") + 1);

            sb.append(gid).append("|").append(scheme).append("//").append(host).append("|").append(logoutUri).append("$");
        }

        log.debug("initialize Agent info tray set ==> " + sb.toString());

        RsResultObject.setResultBody(sb.toString());
    }

    @Override
    public void paramSet() {
        reqData.put("auditType", RsServiceType.TRAYAGENTINFOSETSERVICE.getClientType());
        reqData.put("eventCode", RsServiceType.TRAYAGENTINFOSETSERVICE.getEventType());
    }
}
