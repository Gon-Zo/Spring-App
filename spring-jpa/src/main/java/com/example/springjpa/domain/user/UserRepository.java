package com.example.springjpa.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Create by park031517@gmail on 2020.07.22
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * SELECT QUERY  AND WHERE QUERY
     */
    @Transactional(readOnly = true)
    User findByEmail(String email);

    @Transactional(readOnly = true)
    User findByName(String name);

    @Transactional(readOnly = true)
    User findByEmailAndName(String email, String name);

    @Transactional(readOnly = true)
    User findByEmailOrName(String email , String name);

    @Transactional(readOnly = true)
    User findByCreateDate(LocalDate createDate);

}
