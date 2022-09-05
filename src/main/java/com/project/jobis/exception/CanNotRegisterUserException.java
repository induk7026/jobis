package com.project.jobis.exception;

public class CanNotRegisterUserException extends BusinessException {

    public CanNotRegisterUserException() { super(ErrorCode.CAN_NOT_REGISTER_USER_INFO);}

    public CanNotRegisterUserException(String message) {
        super(message, ErrorCode.COMMON_ILLEGAL_STATUS);
    }
}
