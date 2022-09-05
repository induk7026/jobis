package com.project.jobis.exception;

public class UserPasswordNotMatchException extends BusinessException {

    public UserPasswordNotMatchException() { super(ErrorCode.USER_PASSWORD_NOT_MATCH);}

    public UserPasswordNotMatchException(String message) {
        super(message, ErrorCode.USER_PASSWORD_NOT_MATCH);
    }
}
