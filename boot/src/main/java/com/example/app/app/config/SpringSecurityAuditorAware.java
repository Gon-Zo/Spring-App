package com.example.app.app.config;

import com.example.app.app.utils.SecurityUtil;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return SecurityUtil.getByCurrentLoginName();
    }

}
