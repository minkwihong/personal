package com.ksign.access.mapper.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAAuditMapper;


@Repository("kaAuditRepo")
public class KAAuditRepository extends BaseRepository implements KAAuditMapper {
	
	@Override
	public ArrayList<HashMap<String, Object>> selectKAAuditList(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAAuditMapper.class).selectKAAuditList(paramMap);
	}

	@Override
	public int selectKAAuditListCount(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAAuditMapper.class).selectKAAuditListCount(paramMap);
	}
}
