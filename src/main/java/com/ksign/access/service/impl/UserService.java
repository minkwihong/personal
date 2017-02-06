package com.ksign.access.service.impl;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksign.access.mapper.impl.KAUserRepository;
import com.ksign.access.service.BaseService;
import com.ksign.access.tool.MessageType;

public class UserService<T> extends BaseService<T> {
	KAUserRepository userRepo = (KAUserRepository) getBeans("kaUserRepo");

	public UserService(HttpServletRequest request, HttpServletResponse response, String postBody) throws IOException {
		super(request, response, postBody);
	}
	
	@Override
	public Object doService(String methodId) {
		if(methodId.equals("userList")) {
			return userList();
		} else if(methodId.equals("userInfo")) {
			return userInfo();
		} else if(methodId.equals("userUpdate")) {
			return userUpdate();
		}else if(methodId.equals("userRegist")) {
			return userRegist();
		}else if(methodId.equals("userDuplCheck")) {
				return userDuplCheck();
		}else {
			return handleError(404, MessageType.SEVICEIDNOTFIND.getMessage());
		}
	}

	private Object userDuplCheck() {
		result.put("count", userRepo.selectKAUserDupCheck(defaultParamMap));

		return gson.toJson(result);
	}

	private Object userRegist() {
		result.put("count", userRepo.registKAUser(defaultParamMap));
		result.put("retUrl", "userList");

		return gson.toJson(result);
	}

	private String userUpdate() {
		result.put("count", userRepo.updateKAUser(defaultParamMap));
		result.put("retUrl", "userList");

		return gson.toJson(result);
	}

	private String userInfo() {
		String userId = request.getParameter("userId");
		defaultParamMap.put("userId", userId);

		result = userRepo.selectKAUser(defaultParamMap);
		if(result != null & result.containsKey("password")) {
			result.remove("password");
		}

		return gson.toJson(result);
	}

	private String userList() {

		result.put("count", userRepo.selectKAUserListCount(defaultParamMap));
		result.put("list", userRepo.selectKAUserList(defaultParamMap));
		result.put("total", defaultParamMap.get("pageNo"));
		result.put("page", defaultParamMap.get("pageNo"));



		//result.put("list", userVoList );


		return gson.toJson(result);
	}
}
