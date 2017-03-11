package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAALoginMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mkh on 2017-01-25.
 */
@Repository("kaLoginRepo")
public class KALoginRepository extends BaseRepository implements KAALoginMapper {


    @Override
    public int selectKALoginListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAALoginMapper.class).selectKALoginListCount(paramMap);
    }

    @Override
    public List<HashMap<String,Object>> selectKALoginList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAALoginMapper.class).selectKALoginList(paramMap);
    }
}
