package com.ggilos.creatorai.common.exception;

public class DomainException extends RuntimeException {
    protected ErrorCode errorCode;

    protected DomainException(String message, ErrorCode errorCode) {
        this.errorCode =  errorCode;
        super(message);
    }
}
