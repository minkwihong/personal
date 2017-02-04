package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.math.BigDecimal;

public class KAStatisticMappVO extends BaseVO {
	private BigDecimal value;
	private String label;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
