package com.ksign.access.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface KAASessionMapper {

	public int selectKADupSessionListCount(HashMap<String, Object> defaultParamMap);
	public List<HashMap<String,Object>> selectKADupSessionList(HashMap<String, Object> defaultParamMap);
}
