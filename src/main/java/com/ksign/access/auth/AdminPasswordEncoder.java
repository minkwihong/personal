package com.ksign.access.auth;

import java.security.MessageDigest;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence rawPw) {
		byte[] result = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(rawPw.toString().getBytes());

			result = md.digest();

			String b64Hashed = new String(Base64.encode(result));

			return b64Hashed;

		} catch(Exception e) {
		
		}
		
		return null;
	}

	@Override
	public boolean matches(CharSequence encodedPassword, String rawPassword) {
		if(encodedPassword == null || rawPassword == null) {
			return false;
		}
		
		return rawPassword.equals(encode(encodedPassword));
	}
}
