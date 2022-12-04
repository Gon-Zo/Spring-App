package com.example.jpa.core.exception;


public enum GlobalErrorCode {

    SERVER_ERROR("A001", "Server Error");

    private String code;

    private String message;

    GlobalErrorCode(String i, String s) {
        this.code = i;
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

}
