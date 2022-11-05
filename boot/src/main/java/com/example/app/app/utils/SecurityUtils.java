package com.example.app.app.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;

public class SecurityUtils {

    public static boolean isAuthenticationTypeAble(String authenticationType) {

        Optional<Collection<? extends GrantedAuthority>> authoritiesOptional = getByAuthorities();

        if (authoritiesOptional.isEmpty()) {
            return Boolean.FALSE;
        }

        Collection<? extends GrantedAuthority> authorities = authoritiesOptional.get();

        return authorities.stream().anyMatch(value -> authenticationType.equals(value.getAuthority()));
    }


    /**
     * GET 로그인 권한
     *
     * @return
     */
    public static Optional<Collection<? extends GrantedAuthority>> getByAuthorities() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();

        return Optional.ofNullable(authentication.getAuthorities());
    }

    /**
     * GET 로그인 유저 이름
     *
     * @return
     */
    public static Optional<String> getByCurrentLoginName() {

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication authentication = securityContext.getAuthentication();

        return Optional.ofNullable(convertByLoginName(authentication));
    }

    private static String convertByLoginName(Authentication authentication) {
        if (ObjectUtils.isEmpty(authentication)) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return userDetails.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }

}
