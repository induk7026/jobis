package com.project.jobis.exception;

public class DuplicateRoomException extends BusinessException {

    public DuplicateRoomException() { super(ErrorCode.DUPLICATE_USER_EMAIL);}

    public DuplicateRoomException(String message) {
        super(message, ErrorCode.DUPLICATE_USER_EMAIL);
    }
}
