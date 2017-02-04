package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAASessionMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mkh on 2017-01-25.
 */
@Repository("kaSessionRepo")
public class KASessionRepository extends BaseRepository implements KAASessionMapper {


    @Override
    public int selectKADupSessionListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAASessionMapper.class).selectKADupSessionListCount(paramMap);
    }

    @Override
    public List<HashMap<String,Object>> selectKADupSessionList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAASessionMapper.class).selectKADupSessionList(paramMap);
    }
}
