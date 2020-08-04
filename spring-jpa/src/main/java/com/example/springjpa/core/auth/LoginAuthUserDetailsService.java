package com.example.springjpa.core.auth;

import com.example.springjpa.domain.group.Group;
import com.example.springjpa.domain.user.User;
import com.example.springjpa.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by park031517@gmail.com on [2020-08-1, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
public class LoginAuthUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public LoginAuthUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByEmail(username);

        List<String> groups = user.getGroups()
                .stream()
                .map(Group::getTitle)
                .collect(Collectors.toList());

        return LoginAuthUser.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .groups(groups)
                .build();

    }

}
