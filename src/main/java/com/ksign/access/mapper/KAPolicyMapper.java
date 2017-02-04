package com.ksign.access.mapper;

import java.util.HashMap;
import java.util.List;

public interface KAPolicyMapper {

	public int selectKAPolicyGrpListCount(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAPolicyGrpList(HashMap<String, Object> defaultParamMap);

	public int selectKAPolicyMappingListCount(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAPolicyMappingList(HashMap<String, Object> defaultParamMap);

	public int registKAPolicyMapping(HashMap<String, Object> defaultParamMap);

	public int selectKAPolicyListCount(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAPolicyList(HashMap<String, Object> defaultParamMap);

    public int selectKAUserListCount(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAUserList(HashMap<String, Object> defaultParamMap);

    List<HashMap<String,Object>> selectKAUserGrpMappingList(HashMap<String, Object> defaultParamMap);

	public int selectKAUserGrpMappingListCount(HashMap<String, Object> defaultParamMap);

	public int registKAPolicyGrpMapping(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAPolicyGrpTList(HashMap<String, Object> defaultParamMap);

	int selectKAPolicyGrpTListCount(HashMap<String, Object> defaultParamMap);

	int selectKAPolicyTListCount(HashMap<String, Object> defaultParamMap);

	List<HashMap<String,Object>> selectKAPolicyTList(HashMap<String, Object> defaultParamMap);

    int updateKAPolicyGrp(HashMap<String, Object> defaultParamMap);

	HashMap<String,Object> selectKAPolicyGrpInfo(HashMap<String, Object> defaultParamMap);

	int registKAPolicyGrp(HashMap<String, Object> defaultParamMap);

	int dulCheckKAPolicyGrp(HashMap<String, Object> defaultParamMap);

    int updateKAPolicy(HashMap<String, Object> defaultParamMap);

	HashMap<String,Object> selectKAPolicyInfo(HashMap<String, Object> defaultParamMap);

	int dulCheckKAPolicy(HashMap<String, Object> defaultParamMap);

	int registKAPolicy(HashMap<String, Object> defaultParamMap);
}
