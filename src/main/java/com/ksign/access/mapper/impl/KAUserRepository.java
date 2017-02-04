package com.ksign.access.mapper.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAUserMapper;

@Repository("kaUserRepo")
public class KAUserRepository  extends BaseRepository implements KAUserMapper {

	@Override
	public int selectKAUserListCount(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAUserMapper.class).selectKAUserListCount(paramMap);
	}

	@Override
	public List<HashMap<String, Object>> selectKAUserList(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAUserMapper.class).selectKAUserList(paramMap);
	}

	@Override
	public HashMap<String, Object> selectKAUser(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAUserMapper.class).selectKAUser(paramMap);
	}

	public int updateKAUser(HashMap<String, Object> paramMap) {
		return sqlSession.getMapper(KAUserMapper.class).updateKAUser(paramMap);
	}

    public int registKAUser(HashMap<String, Object> defaultParamMap) {
		return sqlSession.getMapper(KAUserMapper.class).registKAUser(defaultParamMap);
    }

	public int selectKAUserDupCheck(HashMap<String, Object> defaultParamMap) {
		return sqlSession.getMapper(KAUserMapper.class).selectKAUserDupCheck(defaultParamMap);
	}
}
