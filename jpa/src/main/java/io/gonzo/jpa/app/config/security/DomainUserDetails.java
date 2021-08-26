package io.gonzo.jpa.app.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class DomainUserDetails extends User {

    public DomainUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public DomainUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean enabled) {
        super(username, password, enabled, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, authorities);
    }

    public DomainUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
