package com.example.springjpa.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Create by park031517@gmail on 2020.07.18
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@ControllerAdvice
public class WebConfiguration {

    @InitBinder
    public void initBuilder(WebDataBinder webDataBinder){
        webDataBinder.initDirectFieldAccess();
    }

}
