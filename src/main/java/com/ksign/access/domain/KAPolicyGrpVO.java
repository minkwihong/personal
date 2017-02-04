package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.util.Date;

public class KAPolicyGrpVO extends BaseVO {
	private String name;
	private String grp_Desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrpDesc() {
		return grp_Desc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grp_Desc = grpDesc;
	}
}
