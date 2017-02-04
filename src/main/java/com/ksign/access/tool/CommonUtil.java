package com.ksign.access.tool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.gson.JsonParseException;
import org.springframework.security.crypto.codec.Base64;

public class CommonUtil {

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
    	
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<HashMap<String, Object>> typeReference = new TypeReference<HashMap<String, Object>>() { };
        HashMap<String, Object> object = objectMapper.readValue(json, typeReference);

        if((String)object.get("password") != null) {
            object.put("password", passwordEncoder((String) object.get("password")));
        }

        return object;
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


	

	
	
	

	
}
