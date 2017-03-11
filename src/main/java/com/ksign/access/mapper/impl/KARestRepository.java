package com.ksign.access.mapper.impl;

import com.ksign.access.mapper.BaseRepository;
import com.ksign.access.mapper.KARestMapper;
import com.ksign.access.mapper.KAUserMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class KARestRepository extends BaseRepository implements KARestMapper {


    @Override
    public Map<String,Object> selectAccountVerify(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).selectAccountVerify(reqMap);
    }

    @Override
    public int insertCurrLoginAuditVerify(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).insertCurrLoginAuditVerify(reqMap);
    }

    @Override
    public void insertLoginAudit(Map<String, Object> reqMap) {
        sqlSession.getMapper(KARestMapper.class).insertLoginAudit(reqMap);
    }

    @Override
    public int currLoginAuditRow() {
        return sqlSession.getMapper(KARestMapper.class).currLoginAuditRow();
    }

    @Override
    public Map<String,Object> selectDuplLoginUser(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).selectDuplLoginUser(reqMap);
    }

    @Override
    public void deleteCurrLoginUser(Map<String, Object> reqMap) {
        sqlSession.getMapper(KARestMapper.class).deleteCurrLoginUser(reqMap);
    }

    @Override
    public int selectAccountFailCnt(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).selectAccountFailCnt(reqMap);
    }

    @Override
    public void insertAccoutFailCnt(Map<String, Object> reqMap) {
        sqlSession.getMapper(KARestMapper.class).insertAccoutFailCnt(reqMap);
    }

    @Override
    public void updateAccountActivation(Map<String, Object> reqData) {
        sqlSession.getMapper(KARestMapper.class).updateAccountActivation(reqData);
    }

    @Override
    public String selectNonceValidation(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).selectNonceValidation(reqMap);
    }

    @Override
    public int selectKAUserInfoCnt(Map<String, Object> reqMap) {
        return sqlSession.getMapper(KARestMapper.class).selectKAUserInfoCnt(reqMap);
    }

    @Override
    public void insertKAUserInfo(Map<String, Object> reqData) {
        sqlSession.getMapper(KARestMapper.class).insertKAUserInfo(reqData);
    }

    @Override
    public int selectKAAuthUriList(Map<String, Object> reqData) {
        return sqlSession.getMapper(KARestMapper.class).selectKAAuthUriList(reqData);
    }


}
