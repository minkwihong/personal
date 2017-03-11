package com.ksign.access.restService.config;


import org.apache.log4j.Logger;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;


/**
 * Created by mkh on 2017-03-09.
 */
public class PropAgentInfo {

    private static PropAgentInfo configure = null;
    public static Logger log = Logger.getLogger(PropAgentInfo.class);
    public LinkedHashMap agentList = null;


    public static PropAgentInfo getInstance()
    {
        if (configure == null) {
            synchronized (PropAgentInfo.class) {
                PropAgentInfo obj = new PropAgentInfo();
                try
                {
                    if (obj.initailize()) configure = obj; else
                        throw new Exception("fail initailize");
                }catch (Exception e) {
                    e.printStackTrace();
                    log.info("[KAConf] cannot read ssoConfigure, " + e.toString());
                }
            }
        }

        return configure;
    }

    private boolean initailize() {
        setAgentConf();
        return true;
    }

    private void setAgentConf() {
        InputStream fis = null;
        Properties properties = new Properties();

        try {

            fis = getClass().getResourceAsStream("/config/agentInfo.conf");
            properties.load(fis);
        }catch(Exception e){
            e.printStackTrace();
        }

        String temp = null;
        if (this.agentList == null) this.agentList = new LinkedHashMap(); else {
            this.agentList.clear();
        }
        String pvalue = null;


        for (int i = 0; ; i++) {
            pvalue = properties.getProperty("agent.gid." + i);
            if (pvalue == null) break;
            String gid = pvalue.trim();

            KAAgentVO agentInfo = new KAAgentVO(i, gid);
            log.info("[KAConf] setup KAServer Agent Gid: " + pvalue);


            temp = properties.getProperty(gid + ".logoutUrl");
            if (temp != null) {
                agentInfo.setLogoutUrl(temp);
                log.info("[KAConf]   - [" + gid + "] setup Agent logout Url: " + temp);
            }

            this.agentList.put(gid, agentInfo);
        }
    }

}
