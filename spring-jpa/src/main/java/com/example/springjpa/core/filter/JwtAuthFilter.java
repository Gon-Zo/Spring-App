package com.example.springjpa.core.filter;

import com.example.springjpa.core.auth.JwtUtils;
import com.example.springjpa.core.auth.LoginAuthUser;
import com.example.springjpa.core.auth.LoginAuthUserDetailsService;
import com.example.springjpa.core.exception.ErrorCode;
import com.example.springjpa.core.exception.WebException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

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

        String url = request.getRequestURI();

        String userName = null;

        if (url.startsWith("/api")) {

            if (isEmpty(authorization)) {
                throw new WebException(ErrorCode.AUTHORIZATION_NOT_FOUND);
            }

            userName = jwtUtils.getUsernameFromToken(authorization);

            if (isEmpty(userName)) {
                throw new WebException(ErrorCode.UNABLE_JWT_TOKEN);
            }

            UserDetails loginAuthUser = loginAuthUserDetailsService.loadUserByUsername(userName);

            Boolean isNotValidate = isNotValidate(authorization, loginAuthUser);

            if (isNotValidate) {
                throw new WebException(ErrorCode.IS_NOT_VALIDATE);
            }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginAuthUser, null, loginAuthUser.getAuthorities());

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        }

        filterChain.doFilter(request , response);

    }

    private String setJwtHeader(String jwtHeader) {
        if (isNotEmpty(jwtHeader)) {
            return jwtHeader.substring(7);
        } else {
            return "";
        }
    }

    private Boolean isNotValidate(String jwtHeader, UserDetails userDetails) {
        return !jwtUtils.validateToken(jwtHeader, userDetails);
    }

}
