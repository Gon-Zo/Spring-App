package com.example.springjpa.core.filter;


import com.example.springjpa.core.WebResultDto;
import com.example.springjpa.core.auth.JwtUtils;
import com.example.springjpa.core.auth.LoginAuthUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by park031517@gmail.com on 2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Slf4j
public class LoginAuthFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    public LoginAuthFilter(AuthenticationManager authenticationManager, JwtUtils jwtUtils){
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        setFilterProcessesUrl("/login");
        setUsernameParameter("email");
        setPasswordParameter("password");
        setPostOnly(Boolean.TRUE);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String email = request.getParameter("email");

        String password = request.getParameter("password");

        log.info("Login User={}", email);

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(email, password);

        this.setDetails(request , authRequest);

        return authenticationManager.authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        ObjectMapper objectMapper = new ObjectMapper();

        LoginAuthUser loginAuthUser = (LoginAuthUser) authResult.getPrincipal();

        Map<String, Object> userInfo = new HashMap<>();

        userInfo.put("email", loginAuthUser);

        String jwt = jwtUtils.doGenerateToken(userInfo, loginAuthUser.getUsername());

        response.getOutputStream()
                .println(objectMapper.writeValueAsString(
                        WebResultDto.builder()
                                .status("200")
                                .message(jwt)
                                .build())
                );
    }

}
