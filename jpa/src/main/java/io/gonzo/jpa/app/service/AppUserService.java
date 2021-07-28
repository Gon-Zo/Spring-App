package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.repository.AppUserRepository;
import io.gonzo.jpa.app.repository.support.AppUserRepositorySupport;
import io.gonzo.jpa.app.web.dto.AppUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository repository;

    private final AppUserRepositorySupport repositorySupport;

    public List<AppUser> getUserList() {
        return repositorySupport.findByAll();
    }

    public void saveAppUser(AppUserDTO dto){
        repository.save(dto.toEntity());
    }

}
