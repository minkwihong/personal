package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KAASessionMapper;
import com.ksign.access.mapper.KAPolicyMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mkh on 2017-01-25.
 */
@Repository("kaPolicyRepo")
public class KAPolicyRepository extends BaseRepository implements KAPolicyMapper {


    @Override
    public int selectKAPolicyGrpListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyGrpListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAPolicyGrpList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyGrpList(paramMap);
    }

    @Override
    public int selectKAPolicyMappingListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyMappingListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAPolicyMappingList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyMappingList(paramMap);
    }

    @Override
    public int registKAPolicyMapping(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).registKAPolicyMapping(paramMap);
    }

    @Override
    public int selectKAPolicyListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAPolicyList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyList(paramMap);
    }

    @Override
    public int selectKAUserListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAUserListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAUserList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAUserList(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAUserGrpMappingList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAUserGrpMappingList(paramMap);
    }

    @Override
    public int selectKAUserGrpMappingListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAUserGrpMappingListCount(paramMap);
    }

    @Override
    public int registKAPolicyGrpMapping(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).registKAPolicyGrpMapping(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAPolicyGrpTList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyGrpTList(paramMap);
    }

    @Override
    public int selectKAPolicyGrpTListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyGrpTListCount(paramMap);
    }

    @Override
    public int selectKAPolicyTListCount(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyTListCount(paramMap);
    }

    @Override
    public List<HashMap<String, Object>> selectKAPolicyTList(HashMap<String, Object> paramMap) {
        return  sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyTList(paramMap);
    }

    @Override
    public int updateKAPolicyGrp(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).updateKAPolicyGrp(paramMap);
    }

    @Override
    public HashMap<String, Object> selectKAPolicyGrpInfo(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyGrpInfo(paramMap);
    }

    @Override
    public int registKAPolicyGrp(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).registKAPolicyGrp(paramMap);
    }

    @Override
    public int dulCheckKAPolicyGrp(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).dulCheckKAPolicyGrp(paramMap);
    }

    @Override
    public int updateKAPolicy(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).updateKAPolicy(paramMap);
    }

    @Override
    public HashMap<String, Object> selectKAPolicyInfo(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).selectKAPolicyInfo(paramMap);
    }

    @Override
    public int dulCheckKAPolicy(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).dulCheckKAPolicy(paramMap);
    }

    @Override
    public int registKAPolicy(HashMap<String, Object> paramMap) {
        return sqlSession.getMapper(KAPolicyMapper.class).registKAPolicy(paramMap);
    }


}
