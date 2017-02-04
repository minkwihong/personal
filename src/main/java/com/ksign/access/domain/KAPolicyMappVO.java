package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

public class KAPolicyMappVO extends BaseVO {
	private String group_Name;
	private String policy_Name;

	public String getGrpName() {
		return group_Name;
	}

	public void setGrpName(String grpName) {
		this.group_Name = grpName;
	}

	public String getPolicyName() {
		return policy_Name;
	}

	public void setPolicyName(String policyName) {
		this.policy_Name = policyName;
	}
}
