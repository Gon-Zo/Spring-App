package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.repository.UserRepository;
import io.gonzo.jpa.app.web.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final UserRepository repository;

    public Optional<List<User>> getUserList() {
        return repository.findByAll();
    }

    public Optional<List<User>> getFoundAppUserList(UserDTO dto) {
        return repository.findByWhere(dto);
    }

    public void saveAppUser(UserDTO dto) {
        repository.save(dto.toEntity());
    }

    public Long updateAppUser(UserDTO dto, Long id) {
        return repository.update(dto, id);
    }

    public Long removeAppUser(Long id) {
        return repository.delete(id);
    }
}
