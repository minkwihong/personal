package com.ksign.access.tool;

import ksign.jce.util.JCEUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.security.crypto.codec.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.HashMap;

public class CommonUtil {

    public static SSOAgentCryptUtil webCipherUtil = null;

	public static HashMap parseRequestMap(HttpServletRequest request) throws UnsupportedEncodingException {
        String tempStr;
        String[] tempStrArr;
        Enumeration e = request.getParameterNames();
        HashMap hm = new HashMap();

        hm.put("requestURI", request.getRequestURI());

        while(e.hasMoreElements()) {
            tempStr = (String)e.nextElement();
            tempStrArr = request.getParameterValues(tempStr);

            if(null != tempStrArr) {
                 hm.put(tempStr, URLDecoder.decode(tempStrArr[0],"UTF-8"));
            }
        }
        return hm;
    }


    public static HashMap<String, Object> convertJsonToObject(String json) throws  IOException {
        HashMap<String, Object> object = null;

    	if(json != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() {
            };
            object = objectMapper.readValue(json, typeReference);

            if ((String) object.get("password") != null) {
                object.put("password", passwordEncoder((String) object.get("password")));
            }
        }else{
            object = new HashMap<String,Object>();
        }

        return object;
    }

    public static HashMap<String,Object> setWebCipher()  {
        try {
            JCEUtil.initProvider();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String,Object> keyIv = new HashMap<String,Object>();
        byte[] key = SSOCipherUtil.doB64Decode("L+Q+5sefZ5/k+iffNN5ZcdKsBvKbwlQTgLdNv5ElwEg=");

        byte[] m_key = new byte[16];
        byte[] m_iv = new byte[16];

        System.arraycopy(key, 0, m_key, 0, 16);
        System.arraycopy(key, 16, m_iv, 0, m_iv.length);

        webCipherUtil = new SSOAgentCryptUtil("SEED", m_key, m_iv);
        webCipherUtil.setGid("Fix_AX_Crypt");
        webCipherUtil.setKeyInfo("L+Q+5sefZ5/k+iffNN5ZcdKsBvKbwlQTgLdNv5ElwEg=");

        keyIv.put("key",m_key);
        keyIv.put("iv",m_iv);

        return keyIv;
    }



    public static String passwordEncoder(String plainPassword){
        byte[] result = null;
        String b64Hashed = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainPassword.toString().getBytes());

            result = md.digest();

            b64Hashed = new String(Base64.encode(result));


        } catch(Exception e) {

        }

        return b64Hashed;
    }


    public static String getHostFromUri(String uri){

        String scheme = uri.substring(0, uri.indexOf("//"));
        String next = uri.substring(uri.indexOf("//") + 2);
        String host = next.substring(0, next.indexOf("/"));

        return host;
    }

}
