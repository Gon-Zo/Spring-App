package com.gonzo.jpa;

import com.gonzo.jpa.conf.InitDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JpaApplication {

    @Autowired
    private InitDataService initDataService;

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @PostConstruct
    public void setUpInItData() {
        initDataService.initData();
    }

}
