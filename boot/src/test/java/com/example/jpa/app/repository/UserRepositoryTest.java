package com.example.jpa.app.repository;

import com.example.jpa.app.domain.User;
import com.example.jpa.app.domain.base.Name;
import com.example.jpa.app.constant.Gender;
import com.example.jpa.app.config.TestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@DisplayName("app_user_test_case")
@ActiveProfiles("mysql")
@Import(TestConfig.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository appUserRepository;

    private final String userName = "test1";

    @BeforeEach
    public void beforeEach() {
        User data = User.builder()
                .name(Name.builder()
                        .firstName(userName)
                        .lastName(userName)
                        .build())
                .email(userName)
                .gender(Gender.MAN)
                .count(new BigDecimal(0))
                .build();
        appUserRepository.save(data);
    }

    @Test
    @DisplayName("find all test case")
    public void findAll() {
        List<User> userList = appUserRepository.findAll();

        userList.stream()
                .filter(user -> userName.equals(user.getName().getFirstName()))
                .findFirst()
                .ifPresent(value -> {
                    Assertions.assertEquals(value.getName().getFirstName(), userName);
                });
    }

}
