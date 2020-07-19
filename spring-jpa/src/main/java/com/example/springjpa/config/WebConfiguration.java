package com.example.springjpa.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class WebConfiguration {

    @InitBinder
    public void initBuilder(WebDataBinder webDataBinder){
        webDataBinder.initDirectFieldAccess();
    }

}
