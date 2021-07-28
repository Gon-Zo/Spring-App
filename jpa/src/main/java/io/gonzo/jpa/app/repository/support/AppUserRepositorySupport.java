package io.gonzo.jpa.app.repository.support;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.gonzo.jpa.app.domain.AppUser;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static io.gonzo.jpa.app.domain.QAppUser.appUser;

@Repository
public class AppUserRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager entityManager;

    public AppUserRepositorySupport(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(AppUser.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public List<AppUser> findByAll(){
        return jpaQueryFactory.selectFrom(appUser).fetch();
    }

}
