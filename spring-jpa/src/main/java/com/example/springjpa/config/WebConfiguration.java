package com.example.springjpa.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/*
@ControllerAdvice
모든 예외를 처리하게 해주는 어노테이션
 */
@Slf4j
@ControllerAdvice
public class WebConfiguration {

    /**
     * @param webDataBinder
     * @InitBinder : 컨트롤러 레벨의 요청들을 처리
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        log.error("ControllerAdvice={}", "WebDataBinder");
        webDataBinder.initDirectFieldAccess();
    }

}
