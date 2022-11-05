package com.example.jpa.data.repository;

import com.example.jpa.data.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
//    @EntityGraph(attributePaths = {"auths"})
    List<Group> findAll();
}
