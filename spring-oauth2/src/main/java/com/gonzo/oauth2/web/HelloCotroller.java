package com.gonzo.oauth2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by park031517@gmail.com on 2020-08-16, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api")
public class HelloCotroller {

    @GetMapping("/hello")
    public String showHello(){
        return "Hello";
    }

}
