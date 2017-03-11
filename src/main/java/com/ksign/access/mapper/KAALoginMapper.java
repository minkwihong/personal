package com.ksign.access.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface KAALoginMapper {

	public int selectKALoginListCount(HashMap<String, Object> defaultParamMap);
	public List<HashMap<String,Object>> selectKALoginList(HashMap<String, Object> defaultParamMap);
}
