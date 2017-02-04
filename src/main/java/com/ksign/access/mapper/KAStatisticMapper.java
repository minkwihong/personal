package com.ksign.access.mapper;

import java.util.HashMap;
import java.util.List;

public interface KAStatisticMapper {

	List<HashMap<String,Object>> selectKAStatisticDunutList(HashMap<String, Object> defaultParamMap);

    List<String> selectKAAgentList();

    List<HashMap<String,Object>> selectKAStatisticAreaList(HashMap<String, Object> defaultParamMap);
}
