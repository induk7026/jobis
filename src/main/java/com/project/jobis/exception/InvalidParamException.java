package com.project.jobis.exception;

public class InvalidParamException extends BusinessException {

    public InvalidParamException() {
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }
    public InvalidParamException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InvalidParamException(String errorMsg) {
        super(errorMsg, ErrorCode.COMMON_INVALID_PARAMETER);
    }
    public InvalidParamException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
