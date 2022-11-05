package com.example.jpa.app.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.time.Instant;

@Slf4j
public class CustomBeforeFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomBeforeFilter.java|status=start|time={}", Instant.now());
        chain.doFilter(request, response);
        log.info("CustomBeforeFilter.java|status=end|time={}", Instant.now());
    }

}
