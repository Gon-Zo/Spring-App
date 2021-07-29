package io.gonzo.jpa.app.repository.support;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import io.gonzo.jpa.app.domain.AppUser;
import io.gonzo.jpa.app.web.dto.AppUserDTO;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
    public List<AppUser> findByAll() {
        return jpaQueryFactory.selectFrom(appUser).fetch();
    }

    @Transactional
    public Long update(AppUserDTO dto, Long id) {
        UpdateClause<JPAUpdateClause> updateBuilder = update(appUser);

        if (StringUtils.isNoneEmpty(dto.getFirstName())) {
            updateBuilder.set(appUser.firstName, dto.getFirstName());
        }

        if (StringUtils.isNoneEmpty(dto.getLastName())) {
            updateBuilder.set(appUser.lastName, dto.getLastName());
        }

        if (StringUtils.isNoneEmpty(dto.getEmail())) {
            updateBuilder.set(appUser.email, dto.getEmail());
        }

        if (StringUtils.isNoneEmpty(dto.getGender())) {
            updateBuilder.set(appUser.gender, dto.getGender());
        }

        if (ObjectUtils.isNotEmpty(dto.getCount())) {
            updateBuilder.set(appUser.count, dto.getCount());
        }

        return updateBuilder
                .where(appUser.id.eq(id))
                .execute();
    }


}
