package com.ksign.access.domain;

import java.util.Date;

import com.ksign.access.model.BaseVO;

public class KAUserVO extends BaseVO {
	private String bankCd;
	private String userId;
	private String gid;
	private String loginState;
	private String finalLoginDate;

	public String getBankCd() {
		return bankCd;
	}

	public void setBankCd(String bankCd) {
		this.bankCd = bankCd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getLoginState() {
		return loginState;
	}

	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}

	public String getFinalLoginDate() {
		return finalLoginDate;
	}

	public void setFinalLoginDate(String finalLoginDate) {
		this.finalLoginDate = finalLoginDate;
	}
}
