package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Long> {
}
