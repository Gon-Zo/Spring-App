package com.example.springjpa.core.utils;

import com.example.springjpa.core.exception.ExceptionDto;
import com.example.springjpa.core.exception.WebException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Create by park031517@gmail.com on 2020-08-3, 월
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public class WebUtils {

    public static String getJsonData(String str, String title) {
        JSONObject jo = new JSONObject(str);
        return String.valueOf(jo.get(title));
    }

    public static void getWebExceptionData(WebException e, HttpServletResponse response) {
        ObjectMapper om = new ObjectMapper();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        try {
            response.getOutputStream()
                    .println(om.writeValueAsString(
                            ExceptionDto.builder()
                                    .code(e.getErrorCode().getCode())
                                    .message(e.getErrorCode().getMessage())
                                    .build()
                    ));
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

}
