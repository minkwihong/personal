package com.ksign.access.mapper;

import java.util.HashMap;

/**
 * Created by mkh on 2017-01-23.
 */
public interface KAAuthMapper {
    public HashMap<String, Object> selectKAAdminById(HashMap<String, Object> paramMap);

    void updateAccessLogByUserName(String username);
}

