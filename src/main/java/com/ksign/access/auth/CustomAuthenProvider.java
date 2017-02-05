package com.ksign.access.auth;

import java.io.Serializable;
import java.util.Collection;

import com.ksign.access.mapper.impl.AuthenRepository;
import com.ksign.access.tool.MessageType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenProvider implements AuthenticationProvider, Serializable {
	private static final long serialVersionUID = 1123752509263201284L;

	@Autowired
    AuthenService authenService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenRepository authenRepo;

    Logger logger = Logger.getLogger(this.getClass());
    
	@Override
	public Authentication authenticate(Authentication authen) throws AuthenticationException {

		String username = authen.getName();
        String password = (String) authen.getCredentials();
		
		LoginToken token = (LoginToken) authenService.loadUserByUsername(username);
		Collection<? extends GrantedAuthority> authorities;
		
		//TODO: Error Message 정의
		try {
			token = (LoginToken) authenService.loadUserByUsername(username);
			if (!passwordEncoder.matches(password, token.getPassword())) throw new BadCredentialsException(MessageType.DIFFERENTPASSWORD.getMessage());
            authorities = token.getAuthorities();
            // 최근접속로그1
            authenRepo.updateAccessLogByUserName(username);
        } catch(UsernameNotFoundException e) {
            logger.error(e.toString());
            throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e) {
            logger.error(e.toString());
            throw new BadCredentialsException(e.getMessage());
        } catch(Exception e) {
            logger.error(e.toString());
            throw new RuntimeException(e.getMessage());
        }

		return new UsernamePasswordAuthenticationToken(token, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authen) {
		//return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authen));
		return true;
	}
}
