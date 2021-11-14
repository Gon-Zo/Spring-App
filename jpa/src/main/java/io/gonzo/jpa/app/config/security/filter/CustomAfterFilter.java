package io.gonzo.jpa.app.config.security.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.time.Instant;

@Slf4j
public class CustomAfterFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomAfterFilter.java|status=start|time={}", Instant.now());
        chain.doFilter(request, response);
        log.info("CustomAfterFilter.java|status=end|time={}", Instant.now());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
