package com.project.jobis.exception;

public class DuplicateUserEmailException extends BusinessException {

    public DuplicateUserEmailException() { super(ErrorCode.DUPLICATE_USER_EMAIL);}

    public DuplicateUserEmailException(String message) {
        super(message, ErrorCode.DUPLICATE_USER_EMAIL);
    }
}
