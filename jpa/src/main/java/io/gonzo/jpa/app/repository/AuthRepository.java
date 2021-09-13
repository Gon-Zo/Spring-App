package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
    @Override
    List<Auth> findAll();

    <T> Collection<T> findByAuthName(String authName, Class<T> type);

    @Modifying
    @Query("update Auth auth set auth.authName = :authName where auth.id = :id")
    long setFixedAuthNameFor(@Param("authName") String authName, @Param("id") Long id);
    
}
