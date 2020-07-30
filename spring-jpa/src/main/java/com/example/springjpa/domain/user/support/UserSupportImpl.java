package com.example.springjpa.domain.user.support;

import com.example.springjpa.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * Create by park031517@gmail on 2020.07.22
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public class UserSupportImpl extends QuerydslRepositorySupport implements UserSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public UserSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(User.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
