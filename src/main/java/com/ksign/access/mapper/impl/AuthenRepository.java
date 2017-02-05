package com.ksign.access.mapper.impl;

import java.util.HashMap;

import com.ksign.access.mapper.KAAuthMapper;
import org.springframework.stereotype.Repository;

import com.ksign.access.mapper.KAAdminMapper;
import com.ksign.access.mapper.BaseRepository;

@Repository("AuthenRepo")
public class AuthenRepository extends BaseRepository implements KAAuthMapper{

	@Override
	public HashMap<String, Object> selectKAAdminById(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAAuthMapper.class).selectKAAdminById(paramMap);
	}

	@Override
	public void updateAccessLogByUserName(String username) {
		sqlSession.getMapper(KAAuthMapper.class).updateAccessLogByUserName(username);
	}
}
