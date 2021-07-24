package io.gonzo.jpa.app.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SampleRepositoySuport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public SampleRepositoySuport(Class<?> domainClass, JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(domainClass);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
