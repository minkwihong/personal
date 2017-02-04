package com.ksign.access.service;

public enum ServiceType {
	AUDIT("audit"),
	USER("user"),
	ADMIN("admin"),
	SESSION("session"),
	POLICY("policy"),
	STATISTIC("statistic"),
	EVAL("eval"),
	QUESTION("question")
	;

	private String serviceId;

	ServiceType(String serviceId) {
		this.serviceId = serviceId;
	}
	
	String getServiceId() {
		return serviceId;
	}
}
