package com.gonzo.jpa.web;

import com.gonzo.jpa.service.user.UserService;
import com.gonzo.jpa.web.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public void createToUser(@RequestBody UserDto dto){
        userService.saveByUser(dto);
    }

}
