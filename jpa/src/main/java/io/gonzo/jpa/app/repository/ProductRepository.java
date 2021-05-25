package io.gonzo.jpa.app.repository;

import io.gonzo.jpa.app.domain.basic.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    <T> Collection<T> findByImg(String img, Class<T> type);
}
