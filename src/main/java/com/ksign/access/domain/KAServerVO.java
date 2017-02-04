package com.ksign.access.domain;

import com.ksign.access.model.BaseVO;

import java.util.Date;

public class KAServerVO extends BaseVO {
	private String serverName;
	private String type;
	private String ip;
	private String port;
	private String url;
	private String gid;
	private String certdn;
	private String usableAgent;
	private Date modDate;

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getCertdn() {
		return certdn;
	}

	public void setCertdn(String certdn) {
		this.certdn = certdn;
	}

	public String getUsableAgent() {
		return usableAgent;
	}

	public void setUsableAgent(String usableAgent) {
		this.usableAgent = usableAgent;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
}
