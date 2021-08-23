package io.gonzo.jpa.app.config.security;

import io.gonzo.jpa.app.domain.Group;
import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

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

        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }

        return createDomainUser(userOptional);
    }

    /**
     * create security user
     *
     * @param userOptional
     * @return
     */
    private DomainUserDetails createDomainUser(Optional<User> userOptional) {

        User loginUser = userOptional.get();

        List<SimpleGrantedAuthority> authList = loginUser.getGroups()
                .stream()
                .map(Group::getAuths)
                .flatMap(Collection::parallelStream)
                .map(auth -> new SimpleGrantedAuthority(auth.getAuthName()))
                .collect(Collectors.toList());

        return new DomainUserDetails(loginUser.getEmail(), loginUser.getPassword(), authList);
    }

}
