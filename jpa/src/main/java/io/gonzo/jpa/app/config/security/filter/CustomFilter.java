package io.gonzo.jpa.app.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.Instant;

@Slf4j
@Component
@WebFilter(urlPatterns = {"/test"})
public class CustomFilter extends GenericFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomFilter.java|status=start|time={}", Instant.now());
        chain.doFilter(request, response);
        log.info("CustomFilter.java|status=end|time={}", Instant.now());
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
