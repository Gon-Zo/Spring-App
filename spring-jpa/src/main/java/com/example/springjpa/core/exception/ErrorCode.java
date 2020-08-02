package com.example.springjpa.core.exception;

import lombok.Getter;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public enum ErrorCode {

    USER_EMAIL_FAIL(500 , "U001" , "User Email Fail"),
    USER_PASSWORD_FAIL(500 , "U001" , "User Password Fail"),
    INTERNAL_SERVER_ERROR(500 , "S001" , "INTERNAL_SERVER_ERROR"),
    AUTHORIZATION_NOT_FOUND(500 , "A001" , "Authorization Not Found"),
    UNABLE_JWT_TOKEN(500 , "A002" , "Unable to get JWT Token");

    @Getter
    private final String code;

    @Getter
    private final String message;

    @Getter
    private final int status;

    ErrorCode(int status , String code, String message ) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}
