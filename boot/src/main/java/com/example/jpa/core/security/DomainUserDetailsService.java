package com.example.jpa.core.security;

import com.example.jpa.domain.Group;
import com.example.jpa.domain.user.User;
import com.example.jpa.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public DomainUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOptional = repository.findByEmail(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        return createDomainUser(userOptional).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private Optional<DomainUserDetails> createDomainUser(Optional<User> userOptional) {

        DomainUserDetails domainUserDetails = null;

        try {

            User loginUser = userOptional.get();

            List<SimpleGrantedAuthority> authList = loginUser.getGroups()
                    .stream()
                    .map(Group::getAuths)
                    .flatMap(Collection::parallelStream)
                    .map(auth -> new SimpleGrantedAuthority(auth.getAuthName()))
                    .collect(Collectors.toList());

            if (CollectionUtils.isEmpty(authList)) {
                throw new AccessDeniedException(String.format(">>>>>>>>>>>>>>>>>>>>>> username %s", loginUser.getEmail()));
            }

            domainUserDetails = new DomainUserDetails(loginUser.getEmail(), loginUser.getPassword(), authList, loginUser.isActive());

        } catch (AccessDeniedException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(domainUserDetails);
    }

}
