package com.ksign.access.mapper;

import java.util.HashMap;
import java.util.List;

public interface KAAdminMapper {
	public List<HashMap<String, Object>> selectKAAdminList(HashMap<String, Object> paramMap);
	int selectKAAdminListCount(HashMap<String, Object> paramMap);
	public HashMap<String,Object> selectKAAdmin(HashMap<String, Object> paramMap);
	public int updateKAAdmin(HashMap<String, Object> paramMap);
	public int registKAAdmin(HashMap<String, Object> paramMap);
	public int dulCheckKAAdmin(HashMap<String, Object> paramMap);
	public int selectKAServerListCount(HashMap<String, Object> defaultParamMap);
	List<HashMap<String,Object>> selectKAServerList(HashMap<String, Object> defaultParamMap);

	HashMap<String,Object> selectKAServer(HashMap<String, Object> defaultParamMap);

	public int updateKAServer(HashMap<String, Object> defaultParamMap);

	int dulCheckKAServer(HashMap<String, Object> defaultParamMap);

	int registKAServer(HashMap<String, Object> defaultParamMap);
}
