package com.ksign.access.service.impl;

import com.ksign.access.domain.KAStatisticMappVO;
import com.ksign.access.mapper.impl.KAStatisticRepository;
import com.ksign.access.mapper.impl.KAUserRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.DomainUtil;
import com.ksign.access.tool.MessageType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StatisticService<T> extends BaseService<T> {
	KAStatisticRepository statisticRepo = (KAStatisticRepository) getBeans("kaStatisticRepo");

	public StatisticService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);
	}
	
	@Override
	public Object doService(String methodId) {
		if(methodId.equals("statisticDunutInfo")) {
			return statisticDunutInfo();
		}else if(methodId.equals("statisticAreaInfo")){
			return statisticAreaInfo();
		}else {
			return handleError(404, MessageType.SEVICEIDNOTFIND.getMessage());
		}
	}

	private String statisticAreaInfo() {
		KAStatisticRepository statisticRepo = (KAStatisticRepository) getBeans("kaStatisticRepo");

		List<String> resultListString = statisticRepo.selectKAAgentList();
		System.out.println("resultListString : " + resultListString);
		defaultParamMap.put("agentList",resultListString);
		List<HashMap<String, Object>> resultMapList = statisticRepo.selectKAStatisticAreaList(defaultParamMap);

		result.put("total", resultMapList);
		result.put("agentList", resultListString);

		return gson.toJson(result);
	}

	private String statisticDunutInfo() {
		KAStatisticRepository statisticRepo = (KAStatisticRepository) getBeans("kaStatisticRepo");

		List<HashMap<String, Object>> resultMapList = statisticRepo.selectKAStatisticDunutList(defaultParamMap);
		List<KAStatisticMappVO> statisticMappVoList = new ArrayList<KAStatisticMappVO>();

		KAStatisticMappVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAStatisticMappVO.class);
				statisticMappVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", statisticMappVoList);

		return gson.toJson(result);
	}


}
