package io.gonzo.jpa.app.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloResource {

    @GetMapping("/test")
    public String test (){
        return "success";
    }



}
