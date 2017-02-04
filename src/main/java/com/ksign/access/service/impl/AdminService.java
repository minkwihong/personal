package com.ksign.access.service.impl;


import com.ksign.access.domain.KAAdminVO;
import com.ksign.access.domain.KAServerVO;
import com.ksign.access.mapper.impl.KAAdminRepository;
import com.ksign.access.mapper.impl.KAAuditRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.CommonUtil;
import com.ksign.access.tool.DomainUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminService<T> extends BaseService<T> {
	public AdminService() { }

	//@Autowired



	public AdminService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);

		//auditRepo = (KAAuditRepository)
	}

	@Override
	public String doService(String methodId) {
		if(methodId.equals("adminList")) {
			return adminList();
		} else if(methodId.equals("adminInfo")){
			return adminInfo();
		} else if(methodId.equals("adminUpdate")) {
			return adminUpdate();
		}else if(methodId.equals("adminRegist")){
			return adminRegist();
		}else if(methodId.equals("adminDuplCheck")) {
			return adminDuplCheck();
		}else if(methodId.equals("serverList")){
			return serverList();
		} else if(methodId.equals("serverInfo")){
			return serverInfo();
		} else if(methodId.equals("serverUpdate")){
			return serverUpdate();
		} else if(methodId.equals("serverDuplCheck")){
			return serverDuplCheck();
		} else if(methodId.equals("serverRegist")){
			return serverRegist();
		} else {
			return null;
		}
	}

	private String serverRegist() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		defaultParamMap.put("password", CommonUtil.passwordEncoder((String)defaultParamMap.get("password")));

		count = adminRepo.registKAServer(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "serverList");

		return gson.toJson(result);
	}

	private String serverDuplCheck() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		count = adminRepo.dulCheckKAServer(defaultParamMap);
		result.put("result" , count);

		return gson.toJson(result);
	}

	private String serverUpdate() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		count = adminRepo.updateKAServer(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "serverList");

		return gson.toJson(result);
	}

	private String serverInfo() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		String serverName = request.getParameter("serverName");
		defaultParamMap.put("serverName", serverName);

		result = adminRepo.selectKAServer(defaultParamMap);
		if(result != null & result.containsKey("password")) {
			result.remove("password");
		}

		return gson.toJson(result);
	}

	private String serverList() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");

		result.put("count", adminRepo.selectKAServerListCount(defaultParamMap));

		List<HashMap<String, Object>> resultMapList = adminRepo.selectKAServerList(defaultParamMap);
		List<KAServerVO> serverVoList = new ArrayList<KAServerVO>();

		KAServerVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAServerVO.class);
				serverVoList.add(vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("list", serverVoList );

		return gson.toJson(result);
	}

	private String adminDuplCheck() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		count = adminRepo.dulCheckKAAdmin(defaultParamMap);
		result.put("result" , count);

		return gson.toJson(result);
	}

	private String adminRegist() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		defaultParamMap.put("password", CommonUtil.passwordEncoder((String)defaultParamMap.get("password")));

		count = adminRepo.registKAAdmin(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "adminList");

		return gson.toJson(result);
	}

	private String adminUpdate() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		count = adminRepo.updateKAAdmin(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "adminList");

		return gson.toJson(result);
	}

	private String adminInfo() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");
		String userId = request.getParameter("userId");
		defaultParamMap.put("userId", userId);

		result = adminRepo.selectKAAdmin(defaultParamMap);
		if(result != null & result.containsKey("password")) {
			result.remove("password");
		}

		return gson.toJson(result);
	}

	private String adminList() {
		KAAdminRepository adminRepo = (KAAdminRepository) getBeans("kaAdminRepo");

		result.put("count", adminRepo.selectKAAdminListCount(defaultParamMap));

		List<HashMap<String, Object>> resultMapList = adminRepo.selectKAAdminList(defaultParamMap);
		List<KAAdminVO> adminVoList = new ArrayList<KAAdminVO>();

		KAAdminVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAAdminVO.class);
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
