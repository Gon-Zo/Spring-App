package com.gonzo.jpa.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface MemberRepository extends JpaRepository<MenuBar , Long> {
    Member findByName(String name);
}
