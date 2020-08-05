package com.example.springjpa.domain.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface GroupRepository extends JpaRepository<Group , Long> {

    @Transactional
    Group findByTitle(String title);

}
