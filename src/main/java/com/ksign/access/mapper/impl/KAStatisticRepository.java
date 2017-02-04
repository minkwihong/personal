package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAStatisticMapper;
import com.ksign.access.mapper.KAUserMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("kaStatisticRepo")
public class KAStatisticRepository extends BaseRepository implements KAStatisticMapper {


    @Override
    public List<HashMap<String, Object>> selectKAStatisticDunutList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAStatisticMapper.class).selectKAStatisticDunutList(paramMap);
    }

    @Override
    public List<String> selectKAAgentList() {
        return  sqlSession.getMapper(KAStatisticMapper.class).selectKAAgentList();
    }

    @Override
    public List<HashMap<String, Object>> selectKAStatisticAreaList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAStatisticMapper.class).selectKAStatisticAreaList(paramMap);
    }
}
