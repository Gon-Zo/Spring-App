package com.example.springjpa;

import com.example.springjpa.core.init.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringJpaApplication {

    @Autowired
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @PostConstruct
    public void setUpInItData(){
       initService.createByStartData();
    }

}
