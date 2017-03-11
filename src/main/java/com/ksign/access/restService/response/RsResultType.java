package com.ksign.access.restService.response;

/**
 * Created by mkh on 2017-03-02.
 */
public enum RsResultType {
    URI_EXTENDS_ERROR("ERR_1001", "This Uri is not auth."), /* URL 검증 에러*/
    PARAM_NOT_ERROR("ERR_1002", "THis is not auth param ."), /* URI파라미터 검증 에러*/
    ACCOUNT_NOT_ACTIVATION("ERR_1003", "This account is not activitaion ."),/* 계정 비활성화 검증 에러*/
    LOGINAUDIT_NOT_ERROR("ERR_1004", " loginAudit is error."), /* 로그인 감사 등록 에러*/
    ACCOUNT_FAILCNT_ERROR("ERR_1005", "This account is failCnt over "), /* 계정 실패카운트 검증 에러*/
    NONCE_VALIDATION_ERROR("ERR_1006", "This nonce is not validation "), /* NONCE 검증 에러*/
    NOT_EXISTUSER_ERROR("ERR_1007", "This is not exist user"), /* 사용자 등록정보없음 에러*/
    EXISTUSER_ERROR("ERR_1008", "This is exist user"), /* 사용자 등록정보있음 에러*/








    UNKNOWABLE_ERROR("ERR_1011", "This is unknowable error ."), /* 범용적 Exception 에러*/
    AUTH_SUCCESS("SUCC_200", "Auth Success."); /* 인증 성공 */

    private String code;
    private String msg;

    RsResultType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }
    public String getMsg() {
        return this.msg;
    }
}
