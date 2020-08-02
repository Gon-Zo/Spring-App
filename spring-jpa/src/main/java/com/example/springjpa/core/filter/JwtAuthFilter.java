package com.example.springjpa.core.filter;

import com.example.springjpa.core.auth.JwtUtils;
import com.example.springjpa.core.auth.LoginAuthUser;
import com.example.springjpa.core.auth.LoginAuthUserDetailsService;
import com.example.springjpa.core.exception.ErrorCode;
import com.example.springjpa.core.exception.WebException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * Create by park031517@gmail.com on 2020-08-2, 일
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final LoginAuthUserDetailsService loginAuthUserDetailsService;

    public JwtAuthFilter(JwtUtils jwtUtils, LoginAuthUserDetailsService loginAuthUserDetailsService) {
        this.jwtUtils = jwtUtils;
        this.loginAuthUserDetailsService = loginAuthUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = setJwtHeader(request.getHeader("Authorization"));

        String userName = null;

        if (isEmpty(authorization)) {
            throw new WebException(ErrorCode.AUTHORIZATION_NOT_FOUND);
        }

        userName = jwtUtils.getUsernameFromToken(authorization);

        if(isEmpty(userName)) {
            throw new WebException(ErrorCode.UNABLE_JWT_TOKEN);
        }

        UserDetails loginAuthUser = loginAuthUserDetailsService.loadUserByUsername(userName);

        Boolean isNotValidate = isNotValidate(authorization, loginAuthUser);

//        if(isNotValidate){
//           throw new
//        }

        filterChain.doFilter(request , response);

    }

    private String setJwtHeader(String jwtHeader){
        return jwtHeader.substring(7);
    }

    private Boolean isNotValidate(String jwtHeader, UserDetails userDetails) {
        return !jwtUtils.validateToken(jwtHeader, userDetails);
    }

}
