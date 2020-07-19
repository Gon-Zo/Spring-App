package com.example.springjpa.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

    /**
     * 엔티티 전체의 데이터 출력
     *
     * @return
     */
    List<Post> findAllBy();

}
