package io.gonzo.jpa.app.config;

import io.gonzo.jpa.app.config.exception.ExceptionDTO;
import io.gonzo.jpa.app.config.exception.GlobalErrorCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {


    @ExceptionHandler(Exception.class)
    public ExceptionDTO custom(Exception e) {

        GlobalErrorCode errorCode = GlobalErrorCode.SERVER_ERROR;

        return ExceptionDTO.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build()
                .toDetailMessage(e);
    }

}
