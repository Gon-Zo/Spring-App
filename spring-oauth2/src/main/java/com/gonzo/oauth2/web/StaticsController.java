package com.gonzo.oauth2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StaticsController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

}
