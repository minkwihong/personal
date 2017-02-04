package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.util.Date;

public class KAPolicyVO extends BaseVO {
	private String name;
	private String type;
	private String effect;
	private String rule;
	private Date modDate;
	private String polDesc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}

	public String getPolDesc() {
		return polDesc;
	}

	public void setPolDesc(String polDesc) {
		this.polDesc = polDesc;
	}
}
