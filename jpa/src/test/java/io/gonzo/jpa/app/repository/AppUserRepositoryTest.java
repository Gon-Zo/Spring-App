package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.config.TestConfig;
import io.gonzo.jpa.app.domain.app.AppUser;
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
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    private final String userName = "test1";

    @BeforeEach
    public void beforeEach() {
        AppUser data = AppUser.builder()
                .firstName(userName)
                .lastName(userName)
                .email(userName)
                .gender(userName)
                .count(new BigDecimal(0))
                .build();
        appUserRepository.save(data);
    }

    @Test
    @DisplayName("find all test case")
    public void findAll() {
        List<AppUser> appUserList = appUserRepository.findAll();

        appUserList.stream()
                .filter(user -> userName.equals(user.getFirstName()))
                .findFirst()
                .ifPresent(value -> {
                    Assertions.assertEquals(value.getFirstName(), userName);
                });
    }

}
