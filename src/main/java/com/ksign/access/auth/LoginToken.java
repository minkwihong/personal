package com.ksign.access.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginToken  implements UserDetails {
	private static final long serialVersionUID = -4980612368981092116L;
	//private KAAdminVO adminVO;
	private HashMap<String, Object> adminInfo;

	public LoginToken(HashMap<String, Object> adminInfo) {
		this.adminInfo = adminInfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

		list.add(new GrantedAuthority() {
			private static final long serialVersionUID = -5834930691518400481L;

			@Override
			public String getAuthority() {
				//TODO: ROLE 정의 시 구현
				
				//String authority = "ROLE_ANNO";
				/*switch(adminVO.getType()) {
				case 1: 
					authority = "ROLE_ADMIN";
					break;
				case 2:
					authority = "ROLE_USER";
					break;
				default:
					authority = "ROLE_ANNO";
				}*/
				
				String authority = "ROLE_ADMIN";
				
				return authority;
			}
		});

		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		//return adminVO.getPassword();
		return (String) adminInfo.get("password");
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		//return adminVO.getUserId();
		return (String) adminInfo.get("userId");
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		//Date expDate = TimeUtil.addMonths(adminVO.getModDate(), 3);
		//return expDate.after(TimeUtil.currentTime());
		return true;
	}

	@Override
	public boolean isEnabled() {
		//return adminVO.getStatus() == 1;
		return true;
	}

/*	public KAAdminVO getAdminVO() {
		return adminVO;
	}

	public void setAdminVO(KAAdminVO adminVO) {
		this.adminVO = adminVO;
	}*/
}
