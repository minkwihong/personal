package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAAdminMapper;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;

/**
 * Created by mkh on 2017-01-23.
 */
@Repository("kaAdminRepo")
public class KAAdminRepository extends BaseRepository implements KAAdminMapper {

    @Override
    public List<HashMap<String, Object>> selectKAAdminList(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAAdminList(paramMap);
    }

    @Override
    public int selectKAAdminListCount(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAAdminListCount(paramMap);
    }

    public HashMap<String,Object> selectKAAdmin(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAAdmin(paramMap);
    }

    public int updateKAAdmin(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).updateKAAdmin(paramMap);
    }

    public int registKAAdmin(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).registKAAdmin(paramMap);
    }

    public int dulCheckKAAdmin(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).dulCheckKAAdmin(paramMap);
    }

    @Override
    public int selectKAServerListCount(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAServerListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAServerList(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAServerList(paramMap);
    }

    @Override
    public HashMap<String, Object> selectKAServer(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).selectKAServer(paramMap);
    }

    @Override
    public int updateKAServer(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).updateKAServer(paramMap);
    }

    @Override
    public int dulCheckKAServer(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).dulCheckKAServer(paramMap);
    }

    @Override
    public int registKAServer(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAAdminMapper.class).registKAServer(paramMap);
    }
}
