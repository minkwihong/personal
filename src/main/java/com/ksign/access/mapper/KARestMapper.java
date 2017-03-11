package com.ksign.access.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface KARestMapper {

	Map<String,Object> selectAccountVerify(Map<String, Object> reqMap);

	int insertCurrLoginAuditVerify(Map<String, Object> reqMap);

	void insertLoginAudit(Map<String, Object> reqMap);

	int currLoginAuditRow();

	Map<String,Object> selectDuplLoginUser(Map<String, Object> reqMap);

	void deleteCurrLoginUser(Map<String, Object> reqMap);

	int selectAccountFailCnt(Map<String, Object> reqMap);

	void insertAccoutFailCnt(Map<String, Object> reqMap);

	void updateAccountActivation(Map<String, Object> reqData);

	String selectNonceValidation(Map<String, Object> reqMap);

	int selectKAUserInfoCnt(Map<String, Object> reqMap);

	void insertKAUserInfo(Map<String, Object> reqData);

    int selectKAAuthUriList(Map<String, Object> reqData);
}
