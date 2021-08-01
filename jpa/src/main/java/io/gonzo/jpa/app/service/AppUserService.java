package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.repository.AppUserRepository;
import io.gonzo.jpa.app.web.dto.AppUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository repository;

    public Optional<List<AppUser>> getUserList() {
        return repository.findByAll();
    }

    public Optional<List<AppUser>> getFoundAppUserList(AppUserDTO dto) {
        return repository.findByWhere(dto);
    }

    public void saveAppUser(AppUserDTO dto) {
        repository.save(dto.toEntity());
    }

    public Long updateAppUser(AppUserDTO dto, Long id) {
        return repository.update(dto, id);
    }

    public Long removeAppUser(Long id) {
        return repository.delete(id);
    }
}
