package com.gonzo.jpa.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzo.jpa.core.exception.ErrorResultDto;
import com.gonzo.jpa.core.exception.WebException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

public class WebUtils {

    public static void showToResultText(WebException we , HttpServletResponse response){

        ObjectMapper om = new ObjectMapper();

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        try {
            response.getOutputStream()
                    .println(om.writeValueAsString(
                            ErrorResultDto.builder()
                                    .code(we.getErrorCode().getCode())
                                    .message(we.getErrorCode().getMessage())
                                    .build()
                    ));
        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }

}
