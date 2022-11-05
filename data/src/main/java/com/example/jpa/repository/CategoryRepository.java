package com.example.jpa.repository;

import com.example.jpa.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByTitle(String title);

    <T> List<T> findByParentIsNull(Class<T> type);
}
