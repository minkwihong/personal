package com.ksign.access.tool;



public enum MessageType {
	DIFFERENTPASSWORD("비밀번호가 일치하지 않습니다."),
	SEVICEIDNOTFIND("서비스ID를 찾을수 없습니다."),
	SERVICEERROR("서비스에 장애가 발생 하였습니다. 관리자에게 문의 하세요.");


	private String message;

	private MessageType(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
