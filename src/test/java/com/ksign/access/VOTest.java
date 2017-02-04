package com.ksign.access;

import com.ksign.access.domain.KAAdminVO;

public class VOTest {
	public static void main(String args[]) {
		
		KAAdminVO vo = new KAAdminVO();
		vo.setUserId("TEST");
		
		
		System.out.println(vo.toString());
	}
}
