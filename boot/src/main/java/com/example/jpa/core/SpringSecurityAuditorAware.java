package com.example.jpa.core;

import com.example.jpa.core.utils.SecurityUtil;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return SecurityUtil.getByCurrentLoginName();
    }

}
