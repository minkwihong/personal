package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.util.Date;

public class KASessionVO extends BaseVO {
	private String loginId;
	private String loginIp;
	//private String password;
	private String loginSession;
	private String loginTime;
	private String loginGid;
	private String status;
	private String modDate;
	private String loginGids;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginSession() {
		return loginSession;
	}

	public void setLoginSession(String loginSession) {
		this.loginSession = loginSession;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginGid() {
		return loginGid;
	}

	public void setLoginGid(String loginGid) {
		this.loginGid = loginGid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getLoginGids() {
		return loginGids;
	}

	public void setLoginGids(String loginGids) {
		this.loginGids = loginGids;
	}
}
