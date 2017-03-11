package com.ksign.access.restService.config;



public class KAAgentVO
{
    public String m_gid = "";
    public String m_logoutUrl = null;
    private int accessIndex = -1;

    public KAAgentVO(int idx, String agentId) {
        this.accessIndex = idx;
        this.m_gid = agentId;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.m_logoutUrl = logoutUrl;
    }

}