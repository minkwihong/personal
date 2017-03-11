package com.ksign.access.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksign.access.tool.MessageType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksign.access.service.BaseService;
import com.ksign.access.service.ServiceTypeFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api")
public class ApiController {
	private Logger log = Logger.getLogger(getClass());
	private String lhead = "[API] ";
	
	
	@RequestMapping(value="{serviceId}/{method}", produces="application/json;charset=UTF-8")
	@ResponseBody
	public Object apiControl(@PathVariable("serviceId") String serviceId,
			                 @PathVariable("method") String method,
			                 //@RequestBody(required = false) Collection collection,
			                 HttpServletRequest req, HttpServletResponse resp,
			                 @RequestBody(required = false) String postBody

			                 )  {
		Object jsonResult = null;
		BaseService<?> service = null;


		if(log.isDebugEnabled()) log.debug(lhead + "serviceId: " + serviceId + ", method: " + method);
		try{
			service = new ServiceTypeFactory().getService(serviceId, req, resp,postBody);
			jsonResult = service.doService(method);
			if(log.isDebugEnabled()) log.debug(lhead + "result: " + jsonResult);

			return jsonResult;
		}catch(Exception e){
			e.printStackTrace();
			return service.handleError(404 , MessageType.SERVICEERROR.getMessage());
		}


	}
}
