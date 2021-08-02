package io.gonzo.jpa.app.repository.support;

import io.gonzo.jpa.app.domain.app.AppUser;
import io.gonzo.jpa.app.web.dto.AppUserDTO;

import java.util.List;
import java.util.Optional;

public interface AppUserRepositorySupport {
    Optional<List<AppUser>> findByAll();
    Optional<List<AppUser>> findByWhere(AppUserDTO dto);
    Long update(AppUserDTO dto , Long id);
    Long delete(Long id);
}
