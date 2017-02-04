package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.util.Date;

public class KAUserMappVO extends BaseVO {
	private String name;
	private String user_id;
	private Date modDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
}
