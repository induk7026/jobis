package com.project.jobis.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."), // 장애 상황
    COMMON_INVALID_PARAMETER("요청한 값이 올바르지 않습니다."),
    COMMON_ENTITY_NOT_FOUND("존재하지 않는 엔티티입니다."),
    USER_PASSWORD_NOT_MATCH("비밀번호가 일치하지 않습니다."),
    DUPLICATE_USER_EMAIL("이미 회원가입 한 이메일입니다."),
    CAN_NOT_REGISTER_USER_INFO("가입 할 수 없는 회원 정보입니다."),
    COMMON_ILLEGAL_STATUS("잘못된 상태값입니다.");


    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}
