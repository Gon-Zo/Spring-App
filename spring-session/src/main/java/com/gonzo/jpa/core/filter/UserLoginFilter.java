package com.gonzo.jpa.core.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gonzo.jpa.core.auth.AuthResultDto;
import com.gonzo.jpa.core.auth.AuthUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@Slf4j
public class UserLoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public UserLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
        setPostOnly(Boolean.TRUE);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String body = getRequestBodyToString(request);

        String email = getJsonData(body, "email");

        String password = getJsonData(body, "password");

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);

        this.setDetails(request, authRequest);

        return authenticationManager.authenticate(authRequest);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        HttpSession session = request.getSession(true);

        session.invalidate();

        HttpSession newSession = request.getSession(true);

        AuthUserDetails authUserDetails = (AuthUserDetails) authResult.getPrincipal();

        long createTime = newSession.getCreationTime();

        // 세션에 값
        newSession.setAttribute("email", authUserDetails.getEmail());

        newSession.setAttribute("groups", authUserDetails.getGroups());

        newSession.setAttribute("createTime", createTime);

        // 세션 유지기간 설정
        // 60 * 30 = 30 분
        int time = 60 * 30;

        newSession.setMaxInactiveInterval(time);

        // 무한
        //newSession.setMaxInactiveInterval(-1);

        ObjectMapper objectMapper = new ObjectMapper();

        response.getOutputStream()
                .println(objectMapper.writeValueAsString(
                        AuthResultDto.builder()
                                .state("500")
                                .message(newSession.getId())
                                .build()
                ));

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }

    private String getRequestBodyToString(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jb.toString();
    }

    private String getJsonData(String str, String title) {
        JSONObject jo = new JSONObject(str);
        return String.valueOf(jo.get(title));
    }

}
