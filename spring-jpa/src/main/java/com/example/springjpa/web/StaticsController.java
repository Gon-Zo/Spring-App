package com.example.springjpa.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
public class StaticsController {

    @GetMapping("/health/check-up")
    public String getCheckUp(){
        return  "SUCCESS";
    }

}
