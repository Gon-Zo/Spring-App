package com.example.springjpa.web;

import com.example.springjpa.service.user.UserService;
import com.example.springjpa.web.dto.UserDto;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
public class StaticsController {

    private final UserService userService;

    public StaticsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/health/check-up")
    public String getCheckUp(){
        return  "SUCCESS";
    }

    @PostMapping("/sign-up")
    public void saveByUserInfo(@RequestBody @NotNull UserDto dto) {
        userService.createByUser(dto);
    }

}
