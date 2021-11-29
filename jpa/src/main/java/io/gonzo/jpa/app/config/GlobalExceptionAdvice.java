package io.gonzo.jpa.app.config;

import io.gonzo.jpa.app.config.exception.GlobalErrorCode;
import io.gonzo.jpa.app.web.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static io.gonzo.jpa.app.utils.ExceptionUtils.getPrintStackTrace;

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
                .data(getPrintStackTrace(e))
                .build();

        return new ResponseEntity(message, status);
    }

}
