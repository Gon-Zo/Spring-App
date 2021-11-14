package io.gonzo.jpa.app.config.security.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@Component("authenticationSuccessHandler")
public class DomainSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if (!CollectionUtils.isEmpty(authorities)) {
            printLog(authentication);
            response.sendRedirect("/home");
            return;
        }

        response.setStatus(401);
        return;
    }

    /**
     * login user print log
     *
     * @param authentication
     */
    private void printLog(Authentication authentication) {
        String name = authentication.getName();
        log.info("login success|user={}|time={}", name, Instant.now());
    }

}
