package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    @Override
    List<Auth> findAll();

    <T> Collection<T> findByAuthName(String authName, Class<T> type);
}
