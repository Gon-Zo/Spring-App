package com.example.springjpa.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 전체 예외 처리
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handleException(Exception e) {

        log.error(e.getMessage());

        log.error(ExceptionUtils.getStackTrace(e));

        return ExceptionDto.builder()
                .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .errorDetail(ExceptionUtils.getStackTrace(e))
                .build();

    }

    /**
     * 커스텀 예외 처리
     */
    @ResponseBody
    @ExceptionHandler(WebException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionDto handleException(WebException e) {

        log.error(e.getMessage());

        log.error(ExceptionUtils.getStackTrace(e));

        ErrorCode errorCode = e.getStaticErrorCode();

        return ExceptionDto.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

    }

}
