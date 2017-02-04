package com.ksign.access.mapper;

import java.util.HashMap;
import java.util.List;

public interface KAUserMapper {
	public int selectKAUserListCount(HashMap<String, Object> paramMap);
	public List<HashMap<String, Object>> selectKAUserList(HashMap<String, Object> paramMap);
	public HashMap<String, Object> selectKAUser(HashMap<String, Object> paramMap);
	public int updateKAUser(HashMap<String, Object> paramMap);
	public int registKAUser(HashMap<String, Object> defaultParamMap);
	int selectKAUserDupCheck(HashMap<String, Object> defaultParamMap);
}
