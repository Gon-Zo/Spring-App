package io.gonzo.jpa.app.config.security.handler;

import io.gonzo.jpa.app.config.security.AuthenticationType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Component("authenticationSuccessHandler")
@RequiredArgsConstructor
public class DomainSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean isSystemAble = isAuthenticationTypeAble(AuthenticationType.SYSTEM, authorities);

        boolean isAdminAble = isAuthenticationTypeAble(AuthenticationType.ADMIN, authorities);

        boolean isUserAble = isAuthenticationTypeAble(AuthenticationType.USER, authorities);

        if (isSystemAble) {
            response.sendRedirect("/system");
            return;
        }

        if (isAdminAble) {
            response.sendRedirect("/admin");
            return;
        }

        if (isUserAble) {
            response.sendRedirect("/user");
            return;
        }

        response.setStatus(401);
        return;
    }

    private boolean isAuthenticationTypeAble(String authenticationType, Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream().anyMatch(value -> authenticationType.equals(value.getAuthority()));
    }

}
