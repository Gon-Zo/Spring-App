package com.example.jpa.app.config.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.jpa.app.constant.AuthenticationTypes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
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
        AuthenticationTypes authenticationTypes = AuthenticationTypes.findOf(exception.getClass().getSimpleName());
        return authenticationTypes.getValue();
    }

}
