package com.example.jpa.repository;

import com.example.jpa.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    @EntityGraph(attributePaths = {"groups", "groups.auths"})
    List<User> findAll();

    @EntityGraph(attributePaths = {"groups", "groups.auths", "userPassword"})
    Optional<User> findByEmail(String email);

    Set<User> findByIdIn(Collection<Long> userIds);

}
