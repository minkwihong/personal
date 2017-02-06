package com.ksign.access.service.impl;


import com.google.gson.Gson;
import com.ksign.access.domain.*;
import com.ksign.access.mapper.impl.KAPolicyRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.DomainUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PolicyService<T> extends BaseService<T> {
	public PolicyService() { }

	//@Autowired



	public PolicyService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);

		//auditRepo = (KAAuditRepository)
	}

	@Override
	public String doService(String methodId) throws UnsupportedEncodingException {
		if(methodId.equals("policyGrpList")) {
			return policyGrpList();
		}else if(methodId.equals("policyMappingList")) {
			return policyMappingList();
		}else if(methodId.equals("registPolicyMapp")){
			return registPolicyMapp();
		}else if(methodId.equals("policyList")){
			return policyList();
		}else if(methodId.equals("userList")){
			return userList();
		}else if(methodId.equals("userGrpMappingList")){
			return userGrpMappingList();
		}else if(methodId.equals("registPolicyGrpMapp")){
			return registPolicyGrpMapp();
		}else if(methodId.equals("policyGrpTList")){
			return policyGrpTList();
		}else if(methodId.equals("policyTList")){
			return policyTList();
		}else if(methodId.equals("policyGrpUpdate")){
			return policyGrpUpdate();
		}else if(methodId.equals("policyGrpInfo")){
			return policyGrpInfo();
		}else if(methodId.equals("policyGrpRegist")){
			return policyGrpRegist();
		}else if(methodId.equals("policyGrpDuplCheck")){
			return policyGrpDuplCheck();
		}else if(methodId.equals("policyUpdate")){
			return policyUpdate();
		}else if(methodId.equals("policyInfo")){
			return policyInfo();
		}else if(methodId.equals("policyDuplCheck")){
			return policyDuplCheck();
		}else if(methodId.equals("policyRegist")){
			return policyRegist();
		}else {
			return null;
		}
	}

	private String policyRegist() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		count = policyRepo.registKAPolicy(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "policyList");

		return gson.toJson(result);
	}

	private String policyDuplCheck() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");
		count = policyRepo.dulCheckKAPolicy(defaultParamMap);
		result.put("result" , count);

		return gson.toJson(result);
	}

	private String policyInfo() throws UnsupportedEncodingException {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result = policyRepo.selectKAPolicyInfo(defaultParamMap);
		if(result != null & result.containsKey("password")) {
			result.remove("password");
		}

		return gson.toJson(result);
	}

	private String policyUpdate() throws UnsupportedEncodingException {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		count = policyRepo.updateKAPolicy(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "policyList");

		return gson.toJson(result);
	}

	private String policyGrpDuplCheck() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");
		count = policyRepo.dulCheckKAPolicyGrp(defaultParamMap);
		result.put("result" , count);

		return gson.toJson(result);
	}

	private String policyGrpRegist() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		count = policyRepo.registKAPolicyGrp(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "policyGrpList");

		return gson.toJson(result);
	}

	private String policyGrpInfo() throws UnsupportedEncodingException {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result = policyRepo.selectKAPolicyGrpInfo(defaultParamMap);
		if(result != null & result.containsKey("password")) {
			result.remove("password");
		}

		return gson.toJson(result);
	}

	private String policyGrpUpdate() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");
		count = policyRepo.updateKAPolicyGrp(defaultParamMap);
		result.put("result" , count);
		result.put("retUrl" , "policyGrpList");

		return gson.toJson(result);
	}

	private String policyTList() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result.put("count", policyRepo.selectKAPolicyTListCount(defaultParamMap));

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAPolicyTList(defaultParamMap);
		List<KAPolicyVO> policyVoList = new ArrayList<KAPolicyVO>();

		KAPolicyVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAPolicyVO.class);
				policyVoList.add(vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("list", policyVoList );

		return gson.toJson(result);
	}

	private String policyGrpTList() throws UnsupportedEncodingException {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result.put("count", policyRepo.selectKAPolicyGrpTListCount(defaultParamMap));

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAPolicyGrpTList(defaultParamMap);
		List<KAPolicyGrpVO> policyGrpVoList = new ArrayList<KAPolicyGrpVO>();

		KAPolicyGrpVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAPolicyGrpVO.class);
				policyGrpVoList.add(vo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("list", policyGrpVoList );

		return gson.toJson(result);
	}

	private String registPolicyGrpMapp() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result.put("total", policyRepo.registKAPolicyGrpMapping(defaultParamMap));
		return gson.toJson(result);
	}

	private String userGrpMappingList() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAUserGrpMappingList(defaultParamMap);
		List<KAUserMappVO> userMappVoList = new ArrayList<KAUserMappVO>();

		KAUserMappVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAUserMappVO.class);
				userMappVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", defaultParamMap.get("pageNo"));
		result.put("rows", policyRepo.selectKAUserGrpMappingListCount(defaultParamMap));
		result.put("list", userMappVoList );
		result.put("page", defaultParamMap.get("pageNo"));

		return gson.toJson(result);
	}

	private String userList() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAUserList(defaultParamMap);
		List<KAUserVO> userVoList = new ArrayList<KAUserVO>();

		KAUserVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAUserVO.class);
				userVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", defaultParamMap.get("pageNo"));
		result.put("rows", policyRepo.selectKAUserListCount(defaultParamMap));
		result.put("list", userVoList );
		result.put("page", defaultParamMap.get("pageNo"));

		return gson.toJson(result);
	}

	private String policyList() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAPolicyList(defaultParamMap);
		List<KAPolicyVO> policyVoList = new ArrayList<KAPolicyVO>();

		KAPolicyVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAPolicyVO.class);
				policyVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", defaultParamMap.get("pageNo"));
		result.put("rows", policyRepo.selectKAPolicyListCount(defaultParamMap));
		result.put("list", policyVoList );
		result.put("page", defaultParamMap.get("pageNo"));

		return gson.toJson(result);
	}

	private String registPolicyMapp() {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		result.put("total", policyRepo.registKAPolicyMapping(defaultParamMap));
		return gson.toJson(result);
	}

	private String policyMappingList() throws UnsupportedEncodingException {
		KAPolicyRepository policyRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		List<HashMap<String, Object>> resultMapList = policyRepo.selectKAPolicyMappingList(defaultParamMap);
		List<KAPolicyMappVO> policyMappVoList = new ArrayList<KAPolicyMappVO>();

		KAPolicyMappVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAPolicyMappVO.class);
				policyMappVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", defaultParamMap.get("pageNo"));
		result.put("rows", policyRepo.selectKAPolicyMappingListCount(defaultParamMap));
		result.put("list", policyMappVoList );
		result.put("page", defaultParamMap.get("pageNo"));

		return gson.toJson(result);
	}

	private String policyGrpList() {

		KAPolicyRepository adminRepo = (KAPolicyRepository) getBeans("kaPolicyRepo");

		List<HashMap<String, Object>> resultMapList = adminRepo.selectKAPolicyGrpList(defaultParamMap);
		List<KAPolicyGrpVO> policyGrpVoList = new ArrayList<KAPolicyGrpVO>();

		KAPolicyGrpVO vo;
		for(HashMap<String, Object> map: resultMapList) {
			try {
				vo = DomainUtil.convertMapToDomainVO(map, KAPolicyGrpVO.class);
				policyGrpVoList.add(vo);

			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		result.put("total", defaultParamMap.get("pageNo"));
		result.put("rows", adminRepo.selectKAPolicyGrpListCount(defaultParamMap));
		result.put("list", policyGrpVoList );
		result.put("page", defaultParamMap.get("pageNo"));

		return gson.toJson(result);
	}



}
