package com.ksign.access.domain;

import java.util.Date;

import com.ksign.access.model.BaseVO;

public class KAAuditVO extends BaseVO {
	private String auditOId;
	
	private Date event_date;
	private String audit_type;
	
	private String event_code;
	private String userId;
	private String userName;
	private String authenMethod;
	private String resName;
	private String resultCode;
	private String detailInfo;
	private String clientIp;
	private String serverName;
	
	public String getAuditOId() {
		return auditOId;
	}
	public void setAuditOId(String auditOId) {
		this.auditOId = auditOId;
	}
	public Date getEvent_date() {
		return event_date;
	}
	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	public String getAudit_type() {
		return audit_type;
	}
	public void setAudit_type(String audit_type) {
		this.audit_type = audit_type;
	}
	public String getEvent_code() {
		return event_code;
	}
	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthenMethod() {
		return authenMethod;
	}
	public void setAuthenMethod(String authenMethod) {
		this.authenMethod = authenMethod;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
}
