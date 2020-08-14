package com.example.springjpa.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by park031517@gmail.com on [2020-08-14, 금]
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

}
