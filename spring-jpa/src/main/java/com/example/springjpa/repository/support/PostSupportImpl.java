package com.example.springjpa.repository.support;

import com.example.springjpa.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PostSupportImpl extends QuerydslRepositorySupport implements PostSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public PostSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Post.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
