package com.example.springjpa.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Create by park031517@gmail.com on 2020-10-8, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
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
