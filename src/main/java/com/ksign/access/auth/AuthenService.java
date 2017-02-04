package com.ksign.access.auth;

import java.util.HashMap;

import com.ksign.access.mapper.KAAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ksign.access.domain.KAAdminVO;
import com.ksign.access.mapper.impl.AuthenRepository;
import com.ksign.access.tool.DomainUtil;

@Service
public class AuthenService implements UserDetailsService {

	@Autowired
	AuthenRepository authenRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		KAAdminVO adminVO = null;
		
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		
		HashMap<String, Object> result = authenRepo.selectKAAdminById(paramMap);
		
		if(result == null) {
		/*	adminVO = new AdminVO();
			adminVO.setAdminId(userId);
			adminVO.setType(99);
			adminVO.setStatus(2);*/
			
			/*adminVO = new KAAdminVO();
			adminVO.setDeActivate("F");*/
			
			result = new HashMap<String, Object>();
			result.put("annonymous", "not user");
		} else {
			/*try {
				adminVO = DomainUtil.convertMapToDomainVO(result, KAAdminVO.class);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		return new LoginToken(result);
	}
}
