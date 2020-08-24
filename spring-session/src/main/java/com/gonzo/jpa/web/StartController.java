package com.gonzo.jpa.web;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/start")
public class StartController {

    @GetMapping("/hello")
    public String showHello(){
        return "Hello";
    }

}
