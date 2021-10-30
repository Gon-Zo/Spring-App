package io.gonzo.jpa.app.config.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component(value = "authenticationFailureHandler")
public class DomainFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        checkedByException(exception);

        exception.printStackTrace();

        request.setAttribute("message", "test success");

    }

    private void checkedByException(AuthenticationException exception) {

        if (exception instanceof BadCredentialsException) {
            //비밀번호불일치
        } else if (exception instanceof UsernameNotFoundException) {
            //계정없음
        } else if (exception instanceof AccountExpiredException) {
            //계정만료
        } else if (exception instanceof CredentialsExpiredException) {
            //비밀번호만료
        } else if (exception instanceof DisabledException) {
            //계정비활성화
        } else if (exception instanceof LockedException) {
            // 계정잠김
        } else {

        }

    }

}
