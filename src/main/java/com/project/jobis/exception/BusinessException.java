package com.project.jobis.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(){
    }

    public BusinessException(ErrorCode errorCode){
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode, Throwable cause){
        super(message, cause);
        this.errorCode = errorCode;
    }
}
