package com.example.springjpa.repository;

import com.example.springjpa.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-10-10, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /*
    SELECT DISTINCT title
    FROM category
     */
    List<Category> findDistinctByTitle();


    List<Category> findByCreateDateIsGreaterThanAndCreateDateLessThan();

}
