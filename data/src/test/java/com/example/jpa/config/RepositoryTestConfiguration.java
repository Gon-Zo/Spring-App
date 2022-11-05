package com.example.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@EnableJpaAuditing
@EntityScan(basePackages = {"com.example.jpa.domain"})
@EnableJpaRepositories(basePackages = {"com.example.jpa.repository"})
public class RepositoryTestConfiguration {
}
