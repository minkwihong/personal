package com.ksign.access.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ksign.access.domain.KAAuditVO;
import com.ksign.access.mapper.impl.KAAuditRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.DomainUtil;

@Service
public class AuditService<T> extends BaseService<T> {
	public AuditService() { }
	
	//@Autowired
	//KAAuditRepository auditRepo;

	
	public AuditService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);
		
		//auditRepo = (KAAuditRepository)
	}

	@Override
	public String doService(String methodId) {
		if(methodId.equals("auditList")) {
			return auditList();
		} else {
			return null;
		}
	}

	private String auditList() {
		KAAuditRepository auditRepo = (KAAuditRepository) getBeans("kaAuditRepo");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("count", auditRepo.selectKAAuditListCount(defaultParamMap));
		
		List<HashMap<String, Object>> resultMapList = auditRepo.selectKAAuditList(defaultParamMap);
		List<KAAuditVO> adminVoList = new ArrayList<KAAuditVO>();

		KAAuditVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAAuditVO.class);
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
