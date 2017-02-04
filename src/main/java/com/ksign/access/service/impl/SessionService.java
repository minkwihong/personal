package com.ksign.access.service.impl;

import com.ksign.access.domain.KAAuditVO;
import com.ksign.access.domain.KASessionVO;
import com.ksign.access.mapper.impl.KAAuditRepository;
import com.ksign.access.mapper.impl.KASessionRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.DomainUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SessionService<T> extends BaseService<T> {
	public SessionService() { }

	//@Autowired
	//KAAuditRepository auditRepo;


	public SessionService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);
		
		//auditRepo = (KAAuditRepository)
	}

	@Override
	public String doService(String methodId) {
		if(methodId.equals("dupSessionList")) {
			return list();
		} else {
			return null;
		}
	}

	private String list() {
		KASessionRepository sessionRepo = (KASessionRepository) getBeans("kaSessionRepo");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("count", sessionRepo.selectKADupSessionListCount(defaultParamMap));
		
		List<HashMap<String, Object>> resultMapList = sessionRepo.selectKADupSessionList(defaultParamMap);
		List<KASessionVO> adminVoList = new ArrayList<KASessionVO>();

		KASessionVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KASessionVO.class);
				adminVoList.add(vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		result.put("list", adminVoList );
		
		return gson.toJson(result);
	}
}
