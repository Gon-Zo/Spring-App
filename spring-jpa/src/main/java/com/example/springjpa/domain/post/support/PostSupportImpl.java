package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PostSupportImpl extends QuerydslRepositorySupport implements PostSupport{

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public PostSupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory, EntityManager entityManager1) {
        super(Post.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager1;
    }

}
