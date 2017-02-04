package com.ksign.access.auth.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;

public class LoginFailureHandler implements AuthenticationFailureHandler {
    public static String DEFAULT_TARGET_PARAMETER = "spring-security-redirect-login-failure";
    private String targetUrlParameter = DEFAULT_TARGET_PARAMETER;

	public String getTargetUrlParameter() {
         return targetUrlParameter;
    }

    public void setTargetUrlParameter(String targetUrlParameter) {
         this.targetUrlParameter = targetUrlParameter;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
     	response.setContentType("application/json");
    	response.setCharacterEncoding("utf-8");

    	HashMap<String, String> result = new HashMap<String, String>();
		
		result.put("result", "fail");
		result.put("message", exception.getMessage());

    	PrintWriter out = response.getWriter();
    	out.print(new Gson().toJson(result));
    	out.flush();
    	out.close();

    }
}
