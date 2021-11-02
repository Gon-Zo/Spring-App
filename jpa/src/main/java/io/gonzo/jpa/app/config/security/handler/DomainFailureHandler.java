package io.gonzo.jpa.app.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component(value = "authenticationFailureHandler")
public class DomainFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        exception.printStackTrace();

        writePrintErrorResponse(response, exception);
    }

    private void writePrintErrorResponse(HttpServletResponse response, AuthenticationException exception) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            Map<String, Object> responseMap = new HashMap<>();

            String message = getExceptionMessage(exception);

            responseMap.put("status", 401);

            responseMap.put("message", message);

            response.getOutputStream().println(objectMapper.writeValueAsString(responseMap));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getExceptionMessage(AuthenticationException exception) {
        if (exception instanceof BadCredentialsException) {
            //비밀번호불일치
            return "비밀번호불일치";
        } else if (exception instanceof UsernameNotFoundException) {
            //계정없음
            return "계정없음";
        } else if (exception instanceof AccountExpiredException) {
            //계정만료
            return "계정만료";
        } else if (exception instanceof CredentialsExpiredException) {
            //비밀번호만료
            return "비밀번호만료";
        } else if (exception instanceof DisabledException) {
            //계정비활성화
            return "계정비활성화";
        } else if (exception instanceof LockedException) {
            // 계정잠김
            return "계정잠김";
        } else {
            return "확인된 에러가 없습니다.";
        }
    }

}
