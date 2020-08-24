package com.gonzo.jpa.core.auth;

import com.gonzo.jpa.domain.user.User;
import com.gonzo.jpa.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public AuthUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByEmail(username);

        UserDetails userDetails = AuthUserDetails.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .groups(Arrays.asList("USER"))
                .build();

        return userDetails;

    }

}
