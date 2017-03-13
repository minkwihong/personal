package com.ksign.access.restService.service.impl;

import com.ksign.access.restService.exception.RequestParamException;
import com.ksign.access.restService.exception.ServiceException;
import com.ksign.access.restService.response.RsServiceType;
import com.ksign.access.restService.response.RsResultObject;
import com.ksign.access.restService.service.RsApiTemplateRequest;
import com.ksign.access.tool.CommonUtil;
import com.ksign.access.tool.KAStringTokenizer;
import com.ksign.access.tool.SSOAgentCryptUtil;
import com.ksign.access.util.KADateTool;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Tray 이슈후 인증 후 서비스 클래스
 * Created by mkh on 2017-03-04.
 */
@Service("trayEventPostService")
@Scope("prototype")
public class TrayEventPostService extends RsApiTemplateRequest {

    public TrayEventPostService(){};

    public TrayEventPostService(Map<String, Object> reqData) {super(reqData);}

    public byte[] key = null;

    public byte[] iv =  null;

    @Override
    public void requestParamValidation() throws RequestParamException {

    }

    @Override
    public void validationService() throws ServiceException {
        log.info("================ TrayEventPostService validationService start ======================");

        Map<String,Object> keyMap = CommonUtil.setWebCipher();

        key = (byte[]) keyMap.get("key");
        iv = (byte[]) keyMap.get("iv");

        SSOAgentCryptUtil cipherUtil = new SSOAgentCryptUtil("SEED", key, iv);
        String loginData = (String) reqData.get("TRAYPARAM");

        String deStr = new String(cipherUtil.doDecodeDecrypt(loginData));

        log.debug("[ trayData ] ===> " + deStr);
        String[] param = KAStringTokenizer.getTokens(deStr, "$");

        for (int i = 0; i < param.length; i++) {
            String paramKey = param[i].split("=")[0];
            String paramValue = param[i].split("=")[1];

            /*테스트 데이터*/
            reqData.put("bankCd","03193");

            if (paramKey.equals("UID"))
                reqData.put("userId",paramValue);
            else if (paramKey.equals("MAC_ADDR"))
                reqData.put("macAddr",paramValue);
            else if (paramKey.equals("BANKCD"))
                reqData.put("bankCd",paramValue);
            else if (paramKey.equals("LOGIN_STATE"))
                reqData.put("loginState",paramValue);
            else if (paramKey.equals("CP"))
                reqData.put("loginIp",paramValue);
            else if (paramKey.equals("GID"))
                reqData.put("gid",paramValue);
            else if (paramKey.equals("CONDITION"))
                if(paramValue.equals("LOGIN")){
                    reqData.put("eventCode","SE01");
                }else if(paramValue.equals("SSO")){
                    reqData.put("eventCode","SE03");
                }else if(paramValue.equals("LOGOUT")){
                    reqData.put("eventCode","SE02");
                }else{
                    throw new ServiceException("this is not exist eventCode... ");
                }
        }


    }

    @Override
    public void postValidationService()  {
        log.info("================ TrayEventPostService postValidationService start ======================");

        if("SE01".equals(reqData.get("eventCode"))){ // 로그인
            restRepo.insertCurrLoginAuditVerify(reqData);
        }else if("SE02".equals(reqData.get("eventCode"))){  //로그아웃
            restRepo.deleteCurrLoginUser(reqData);
        }else if("SE03".equals(reqData.get("eventCode"))){}else{}// SSO 발생

        reqData.put("resultCode","T");
        audit.registLoginAudit(reqData);

        String respMsg = "OK$" + reqData.get("userId") + "$" + KADateTool.getCurrentDate();
        RsResultObject.setResultBody(respMsg);
    }

    @Override
    public void paramSet() {reqData.put("auditType", RsServiceType.TRAYEVENTPOSTSERVICE.getClientType());}
}
