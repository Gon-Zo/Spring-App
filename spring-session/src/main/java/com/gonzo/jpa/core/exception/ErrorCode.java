package com.gonzo.jpa.core.exception;

import lombok.Getter;

public enum ErrorCode {

    NotFoundSession(500 , "S001" , "Session is not found");

    @Getter
    private final int state;

    @Getter
    private final String code;

    @Getter
    private final String message;

    ErrorCode(int state, String code, String message) {
        this.state = state;
        this.code = code;
        this.message = message;
    }

}
