package com.example.jpa.app.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Jpa configuration </br>
 * Queerydsl configuration </br>
 *
 * @author gon-zo
 */
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "io.gonzo.jpa.app.repository")
public class JpaConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean(name = "jpaQueryFactory")
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public SpringSecurityAuditorAware auditorAware() {
        return new SpringSecurityAuditorAware();
    }

}
