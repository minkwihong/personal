package com.ksign.access.service.impl;

import com.ksign.access.domain.KALoginVO;
import com.ksign.access.mapper.impl.KALoginRepository;
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
public class LoginService<T> extends BaseService<T> {
	public LoginService() { }

	//@Autowired
	//KAAuditRepository auditRepo;


	public LoginService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);
		
		//auditRepo = (KAAuditRepository)
	}

	@Override
	public String doService(String methodId) {
		if(methodId.equals("loginList")) {
			return list();
		} else {
			return null;
		}
	}

	private String list() {
		KALoginRepository loginRepo = (KALoginRepository) getBeans("kaLoginRepo");
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		result.put("count", loginRepo.selectKALoginListCount(defaultParamMap));
		
		List<HashMap<String, Object>> resultMapList = loginRepo.selectKALoginList(defaultParamMap);
		List<KALoginVO> adminVoList = new ArrayList<KALoginVO>();

		KALoginVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KALoginVO.class);
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
