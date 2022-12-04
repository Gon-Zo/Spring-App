package com.example.jpa.repository;

import com.example.jpa.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
//    @EntityGraph(attributePaths = {"auths"})
    List<Group> findAll();
}
