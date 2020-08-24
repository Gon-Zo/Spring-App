package com.gonzo.jpa.core.exception;

import lombok.Getter;

public class WebException extends RuntimeException{

    @Getter
    private ErrorCode errorCode;

    public WebException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public WebException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public WebException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public WebException(Throwable cause, ErrorCode errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public WebException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCode errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

}
