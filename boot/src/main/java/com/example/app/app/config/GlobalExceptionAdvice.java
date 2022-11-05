package com.example.app.app.config;

import com.example.app.app.config.exception.GlobalErrorCode;
import com.example.app.app.utils.ExceptionUtils;
import com.example.app.app.web.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity custom(Exception e) {
        ResponseEntity message = responseEntity(GlobalErrorCode.SERVER_ERROR, e, HttpStatus.INTERNAL_SERVER_ERROR);
        return message;
    }

    private ResponseEntity responseEntity(GlobalErrorCode errorCode, Exception e, HttpStatus status) {

        e.printStackTrace();

        MessageDTO.Error message = MessageDTO.Error.builder()
                .status(status.value())
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .data(ExceptionUtils.getPrintStackTrace(e))
                .build();

        return new ResponseEntity(message, status);
    }

}
