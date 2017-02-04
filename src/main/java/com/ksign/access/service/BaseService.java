package com.ksign.access.service;

import java.io.*;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ksign.access.tool.GsonDateTypeAdaptor;
import com.ksign.access.tool.CommonUtil;

public abstract class BaseService<T> {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected String callback;
	protected String jsonMsg;

	protected boolean isJsonp;
	protected byte[] content;

	protected GsonBuilder gsonBuilder;
	protected Gson gson;
	protected Authentication auth; 

	protected HashMap<String, Object> defaultParamMap = null;
	protected String postBody = null;
	protected int count = 0;

	protected HashMap<String,Object> result = null;

	protected HashMap<String,Object> reqMapData = null;

	protected org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(getClass());

	public BaseService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		this.request = request;
		this.response = response;
		this.postBody = postBody;
		gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Date.class, new GsonDateTypeAdaptor());
		gson = gsonBuilder.create();
		auth = SecurityContextHolder.getContext().getAuthentication();
		result = new HashMap<String, Object>();

		parseDefaultParam();
	}

	public BaseService() {

	}

	public Object getBeans(String beansName) {
		return ContextLoader.getCurrentWebApplicationContext().getBean(beansName);
	}

	protected void parseDefaultParam() throws IOException {
		if(defaultParamMap == null) defaultParamMap = new HashMap<String, Object>();

		if(request == null || response == null) return;


		if(request.getMethod().equals("POST") && postBody != null){
			reqMapData = CommonUtil.convertJsonToObject(postBody);
		}else if(request.getMethod().equals("GET")){
			reqMapData = CommonUtil.parseRequestMap(request);
		}else if(request.getMethod().equals("PATCH") && postBody != null){
			reqMapData = CommonUtil.convertJsonToObject(postBody);
		}else if(request.getMethod().equals("DELETE") && postBody != null) {

		}else if(request.getMethod().equals("PUT") && postBody != null){

		}

		int pageNo = reqMapData.get("pageNo") != null ? Integer.valueOf((String) reqMapData.get("pageNo")) : -1;
		int pageSize = reqMapData.get("pageSize") != null ? Integer.valueOf((String) reqMapData.get("pageSize")) : -1;
		reqMapData.put("pageSize",pageSize);
		reqMapData.put("pageNo",pageNo);

		defaultParamMap.putAll(reqMapData);

		log.debug(" [ defaultParameterMap ] ==> " + defaultParamMap.toString());
	}

	
	protected void readRequest(boolean contentUsed) throws IOException {
		callback = request.getParameter("callback");
		isJsonp = (callback != null && callback.length() > 0); 

		if(contentUsed) {
			content = readContent(new BufferedInputStream(request.getInputStream()), request.getContentLength());
			jsonMsg = content != null ? new String(content, "UTF-8") : null;

			if(isJsonp) jsonMsg = extractJsonpRequestParameter(request);
		}
	}

	public static byte[] readContent(InputStream is, int contentLength) throws IOException {
		if(contentLength < 0) return null;

		byte[] buf = new byte[contentLength];
		for(int idx=0; idx<buf.length; ) {
			int read = is.read(buf, idx, buf.length - idx);
			if(read < 0) throw new EOFException("illegal eof reached");
			idx += read;
		}

		return buf;
	}

	public static String extractJsonpRequestParameter(HttpServletRequest req) throws IOException {
		String jsonMsg = null;
		for(Enumeration<String> e = req.getParameterNames(); e.hasMoreElements(); ) {
			String paramName = e.nextElement();
			if(paramName.startsWith("{") && paramName.endsWith("}")) {
				jsonMsg = new String(paramName.getBytes("8859_1"), "UTF-8");
				break;
			}
		}
		return jsonMsg;
	}

	public static String toKor(String s) {
		if(s == null) return null;
		try {
			return new String(s.getBytes("8859_1"), "UTF-8");
		} catch(Exception ignored) {
			// do nothing..
		}

		return s;
	}

	public abstract Object doService(String methodId) throws UnsupportedEncodingException;
	
	public String handleError(int code, String message) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("code", result);
		result.put("message", message);
		
		return gson.toJson(result);
	}



}
 