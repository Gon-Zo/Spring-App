package io.gonzo.jpa.app.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("authenticationProvider")
public class DomainAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    private final DomainUserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String loginId = authentication.getName();

        String password = (String) authentication.getCredentials();

        DomainUserDetails domainUserDetails = (DomainUserDetails) userDetailsService.loadUserByUsername(loginId);

        if (isNotMatches(password, domainUserDetails.getPassword())) {
            throw new BadCredentialsException(loginId);
        }

        return new UsernamePasswordAuthenticationToken(domainUserDetails, domainUserDetails.getPassword(), domainUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    private boolean isNotMatches(String password, String encodePassword) {
        return !passwordEncoder.matches(password, encodePassword);
    }

}
