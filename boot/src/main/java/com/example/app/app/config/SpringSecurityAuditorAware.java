package com.example.app.app.config;

import com.example.app.app.utils.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return SecurityUtils.getByCurrentLoginName();
    }

}
