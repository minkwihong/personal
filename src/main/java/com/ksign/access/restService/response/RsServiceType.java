package com.ksign.access.restService.response;

public enum RsServiceType {
	/* 서비스 타입 , 이벤트 타입 , 클라이언트타입 */
	AUTHSUCCSERVICE("authSuccService" , "SE06", "API"),  /* 인증 성공시 SEVICE*/
	AUTHFAILSERVICE("authFailService" , "SE07","API"),  /* 인증 실패시 SEVICE*/
	TRAYLOGINPOSTSERVICE("trayLoginPostService", " ", "TRAY"), /* TRAY 이슈시 SEVICE*/
	TRAYLOGOUTPOSTSERVICE("trayLogoutPostService", "SE02" ,"TRAY"), /* TRAY loginout 시 SEVICE*/
	NONCEVALIDATIONSERVICE("nonceValidationService", "SE04" ,"API"), /* NONCE 값 인증 SEVICE*/
	TRAYCONFINFOSERVICE("trayConfInfoService" , " ","TRAY"), /* tray AgentConf set SEVICE*/
	INITIALLOGINSERVICE("initialLoginService", "SE05" ,"API"), /* 최초 사용자 등록시 SEVICE*/




	;

	private String serviceId;
	private String eventType;
	private String clientType;

	RsServiceType(String serviceId , String eventType, String clientType) {
		this.serviceId = serviceId;
		this.eventType = eventType;
		this.clientType = clientType;
	}
	
	public String getServiceId() {
		return serviceId;
	}
	public String getEventType() {return this.eventType;}
	public String getClientType() {return this.clientType;}
}
