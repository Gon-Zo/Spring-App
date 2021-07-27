package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.repository.support.AppUserRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepositorySupport repositorySupport;

    public List<AppUser> getUserList() {
        return repositorySupport.findByAll();
    }

}
