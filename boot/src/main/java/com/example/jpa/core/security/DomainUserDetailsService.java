package com.example.jpa.core.security;

import com.example.jpa.constant.UserStatus;
import com.example.jpa.core.exception.BlockUserException;
import com.example.jpa.core.exception.DeleteUserException;
import com.example.jpa.domain.Group;
import com.example.jpa.domain.user.User;
import com.example.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));

        changedByLastUser(user);

        return createDomainUser(user);
    }

    private DomainUserDetails createDomainUser(User loginUser) {

        DomainUserDetails domainUserDetails;

        try {

            List<SimpleGrantedAuthority> authList = loginUser.getGroups().stream().map(Group::getAuths).flatMap(Collection::parallelStream).map(auth -> new SimpleGrantedAuthority(auth.getAuthName())).collect(Collectors.toList());

            if (CollectionUtils.isEmpty(authList)) {
                throw new AccessDeniedException(String.format(">>>>>>>>>>>>>>>>>>>>>> username %s", loginUser.getEmail()));
            }

            domainUserDetails = new DomainUserDetails(loginUser.getEmail(), loginUser.getUserPassword().getPassword(), authList, loginUser.isActive());

        } catch (AccessDeniedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return domainUserDetails;
    }

    private void changedByLastUser(User user) {

        UserStatus status = user.getStatus();

        switch (status) {
            case BLOCK -> throw new BlockUserException(user.getId().toString());
            case DELETE -> throw new DeleteUserException(user.getId().toString());
            case DORMANCY, DORMANCY_READY -> {
                user.setDefaultStatus();
                userRepository.save(user);
            }
        }

    }
}
