package io.gonzo.jpa.app.repository.support;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.web.dto.UserStoreDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepositorySupport {
    Optional<List<User>> findByAll();
    Optional<List<User>> findByWhere(UserStoreDTO dto);
    Long update(UserStoreDTO dto , Long id);
    Long delete(Long id);
}
