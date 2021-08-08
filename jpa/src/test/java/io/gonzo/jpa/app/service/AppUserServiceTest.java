package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.app.AppUser;
import io.gonzo.jpa.app.repository.AppUserRepository;
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
class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    @MockBean
    private AppUserRepository appUserRepository;

    @Test
    @DisplayName("유저 목록")
    public void getUserList(){
        Optional<List<AppUser>> userList = appUserService.getUserList();

        return;
    }

}
