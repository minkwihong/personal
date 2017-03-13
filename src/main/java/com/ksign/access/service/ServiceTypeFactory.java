package com.ksign.access.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksign.access.service.impl.*;

public class ServiceTypeFactory {
	ServiceType type = null;
	
	public ServiceTypeFactory() {
	}

	public BaseService<?> getService(String serviceId, HttpServletRequest request, HttpServletResponse response, String postData) throws IOException {
		type = ServiceType.valueOf(serviceId.toUpperCase());

		switch(type) {
		case AUDIT:
			return new AuditService(request, response, postData);
		case USER:
			return new UserService(request, response, postData);
		case ADMIN:
			return new AdminService(request, response, postData);
		case LOGIN:
			return new LoginService(request, response, postData);
		case POLICY:
			return new PolicyService(request, response, postData);
		case STATISTIC:
			return new StatisticService(request, response, postData);
		default:
			return null;
		}
	}
}
