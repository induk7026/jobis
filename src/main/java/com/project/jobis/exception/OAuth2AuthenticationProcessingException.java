package com.project.jobis.exception;

public class OAuth2AuthenticationProcessingException extends BusinessException {

    public OAuth2AuthenticationProcessingException() {
        super(ErrorCode.COMMON_INVALID_PARAMETER);
    }

    public OAuth2AuthenticationProcessingException(String message) {
        super(message, ErrorCode.COMMON_INVALID_PARAMETER);

    }
}
