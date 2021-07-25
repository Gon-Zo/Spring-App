package io.gonzo.jpa.app.repository.support;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.gonzo.jpa.app.domain.basic.Customers;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SampleRepositoySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public SampleRepositoySupport(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Customers.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
