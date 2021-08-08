package io.gonzo.jpa.app.repository.support;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.web.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepositorySupport {
    Optional<List<User>> findByAll();
    Optional<List<User>> findByWhere(UserDTO dto);
    Long update(UserDTO dto , Long id);
    Long delete(Long id);
}
