package com.project.jobis.exception;

public class BadRequestException extends BusinessException {

    public BadRequestException() { super(ErrorCode.COMMON_INVALID_PARAMETER);}

    public BadRequestException(String message) {
        super(message, ErrorCode.COMMON_ILLEGAL_STATUS);
    }
}
