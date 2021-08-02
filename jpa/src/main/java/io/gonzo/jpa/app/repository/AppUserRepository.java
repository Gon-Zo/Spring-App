package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.app.AppUser;
import io.gonzo.jpa.app.repository.support.AppUserRepositorySupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser , Long>  , AppUserRepositorySupport {
}
