package com.example.springjpa.core.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ExceptionDto {

    private String code;

    private String message;

    private String errorDetail;

    @Builder
    public ExceptionDto(String code, String message, String errorDetail) {
        this.code = code;
        this.message = message;
        this.errorDetail = errorDetail;
    }

}
