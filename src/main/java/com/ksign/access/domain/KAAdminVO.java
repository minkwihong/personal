package com.ksign.access.domain;

import java.util.Date;

import com.ksign.access.model.BaseVO;

public class KAAdminVO extends BaseVO {
	private String userId;
	private String name;
	//private String password;
	private String passwordReset;
	private String deActivate;
	private String allowedIp;
	private String title;
	private String email;
	private String telephoneNumber;
	private String mobile;
	private String description;
	
	private int passwordFailureCount;
	
	private Date lastLoginTime;
	private Date passwordCreatedTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}*/

	public String getPasswordReset() {
		return passwordReset;
	}

	public void setPasswordReset(String passwordReset) {
		this.passwordReset = passwordReset;
	}

	public String getDeActivate() {
		return deActivate;
	}

	public void setDeActivate(String deActivate) {
		this.deActivate = deActivate;
	}

	public String getAllowedIp() {
		return allowedIp;
	}

	public void setAllowedIp(String allowedIp) {
		this.allowedIp = allowedIp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getPasswordFailureCount() {
		return passwordFailureCount;
	}

	public void setPasswordFailureCount(int passwordFailureCount) {
		this.passwordFailureCount = passwordFailureCount;
	}

	public Date getPasswordCreatedTime() {
		return passwordCreatedTime;
	}

	public void setPasswordCreatedTime(Date passwordCreatedTime) {
		this.passwordCreatedTime = passwordCreatedTime;
	}
}
