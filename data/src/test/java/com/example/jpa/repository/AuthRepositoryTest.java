package com.example.jpa.repository;

import com.example.jpa.config.RepositoryTestConfiguration;
import com.example.jpa.domain.Auth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = {RepositoryTestConfiguration.class})
class AuthRepositoryTest {

    @Autowired
    private AuthRepository authRepository;

    @Test
    @Order(1)
    @DisplayName("Auth Single Data Save")
    void save_success_test() {

        Auth mock = Auth.newAuthOf("ROLE_USER");

        Auth entity = authRepository.save(mock);

        assertEquals(mock.getAuthName(), entity.getAuthName());
    }
}