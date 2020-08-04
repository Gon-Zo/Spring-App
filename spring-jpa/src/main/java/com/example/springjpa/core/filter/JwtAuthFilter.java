package com.example.springjpa.core.filter;

import com.example.springjpa.core.auth.JwtUtils;
import com.example.springjpa.core.auth.LoginAuthUserDetailsService;
import com.example.springjpa.core.exception.ErrorCode;
import com.example.springjpa.core.exception.ExceptionDto;
import com.example.springjpa.core.exception.WebException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        String url = request.getRequestURI();

        String authorization = null;

        String userName = null;

        try {

            if (url.startsWith("/api")) {

                try {
                    authorization = request.getHeader("Authorization").substring(7);
                } catch (NullPointerException e) {
                    throw new WebException(ErrorCode.AUTHORIZATION_NOT_FOUND);
                }

                try {
                    userName = jwtUtils.getUsernameFromToken(authorization);
                } catch (IllegalArgumentException e) {
                    throw new WebException(ErrorCode.UNABLE_JWT_TOKEN);
                } catch (ExpiredJwtException e) {
                    throw new WebException(ErrorCode.EXPIRED_JWT_TOKEN);
                }

                UserDetails loginAuthUser = loginAuthUserDetailsService.loadUserByUsername(userName);

                Boolean isNotValidate = isNotValidate(authorization, loginAuthUser);

                if (isNotValidate) {

                    throw new WebException(ErrorCode.IS_NOT_VALIDATE);

                } else {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginAuthUser, null, loginAuthUser.getAuthorities());

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);


                }

            }

            filterChain.doFilter(request, response);

        } catch (WebException e) {
            e.printStackTrace();
            getWebExceptionData(e, response);
        }


    }

    private Boolean isNotValidate(String jwtHeader, UserDetails userDetails) {
        return !jwtUtils.validateToken(jwtHeader, userDetails);
    }

    private void getWebExceptionData(WebException e, HttpServletResponse response) {
        ObjectMapper om = new ObjectMapper();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        try {
            response.getOutputStream()
                    .println(om.writeValueAsString(
                            ExceptionDto.builder()
                                    .code(e.getErrorCode().getCode())
                                    .message(e.getErrorCode().getMessage())
                                    .build()
                    ));
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

}
