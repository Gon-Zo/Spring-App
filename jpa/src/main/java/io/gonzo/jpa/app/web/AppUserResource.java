package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/app-user")
@RequiredArgsConstructor
public class AppUserResource {

    private final AppUserService service;

    @GetMapping("")
    public List<AppUser> showByAppUser(){
        return service.getUserList();
    }

}
