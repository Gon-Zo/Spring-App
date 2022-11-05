package com.example.jpa.app.service;

import com.example.jpa.data.domain.User;
import com.example.jpa.data.repository.UserRepository;
import com.example.jpa.api.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

@ActiveProfiles({"mysql" , "test"})
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository appUserRepository;

    @Test
    @DisplayName("유저 목록")
    public void getUserList(){
        Optional<List<User>> userList = userService.getUserList();

        return;
    }

}
