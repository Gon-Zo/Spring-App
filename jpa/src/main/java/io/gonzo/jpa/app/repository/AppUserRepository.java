package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser , Long> {
}
