package io.gonzo.jpa.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfiguration {

    @Bean
    public SpringSecurityAuditorAware auditorAware() {
        return new SpringSecurityAuditorAware();
    }

}
