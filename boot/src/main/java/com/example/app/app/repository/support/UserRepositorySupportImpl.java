package com.example.app.app.repository.support;

//import com.example.app.app.domain.User;
//import com.example.app.app.web.dto.UserStoreDTO;
//import com.querydsl.core.BooleanBuilder;
//import com.querydsl.core.dml.UpdateClause;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.querydsl.jpa.impl.JPAUpdateClause;
//import org.apache.commons.lang3.ObjectUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//
//import java.util.List;
//import java.util.Optional;
//
//import static io.gonzo.jpa.app.domain.QUser.user;
//
//@Repository
//public class UserRepositorySupportImpl extends QuerydslRepositorySupport implements UserRepositorySupport {
//
//    private final JPAQueryFactory jpaQueryFactory;
//
//    private final EntityManager entityManager;
//
//    public UserRepositorySupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
//        super(User.class);
//        this.jpaQueryFactory = jpaQueryFactory;
//        this.entityManager = entityManager;
//    }
//
////    public void find_
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<List<User>> findByAll() {
//        return Optional.ofNullable(jpaQueryFactory.selectFrom(user).fetch());
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Optional<List<User>> findByWhere(UserStoreDTO dto) {
//        return Optional.ofNullable(
//                jpaQueryFactory.selectFrom(user)
//                        .where(setWhereBuilder(dto))
//                        .fetch()
//        );
//    }
//
//    @Override
//    @Transactional
//    public Long update(UserStoreDTO dto, Long id) {
//
//        UpdateClause<JPAUpdateClause> updateBuilder = update(user);
//
//        if (StringUtils.isNotEmpty(dto.getFirstName())) {
//            updateBuilder.set(user.name.firstName, dto.getFirstName());
//        }
//
//        if (StringUtils.isNotEmpty(dto.getLastName())) {
//            updateBuilder.set(user.name.lastName, dto.getLastName());
//        }
//
//        if (StringUtils.isNotEmpty(dto.getEmail())) {
//            updateBuilder.set(user.email, dto.getEmail());
//        }
//
//        if (ObjectUtils.isNotEmpty(dto.getGender())) {
//            updateBuilder.set(user.gender, dto.getGender());
//        }
//
//        if (ObjectUtils.isNotEmpty(dto.getCount())) {
//            updateBuilder.set(user.count, dto.getCount());
//        }
//
//        return updateBuilder
//                .where(user.id.eq(id))
//                .execute();
//    }
//
//    @Transactional
//    public Long delete(Long id) {
//        return delete(user).where(user.id.eq(id)).execute();
//    }
//
//    private BooleanBuilder setWhereBuilder(UserStoreDTO dto) {
//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        if (StringUtils.isNotEmpty(dto.getFirstName())) {
//            booleanBuilder.and(user.name.firstName.eq(dto.getFirstName()));
//        }
//
//        if (StringUtils.isNotEmpty(dto.getLastName())) {
//            booleanBuilder.and(user.name.lastName.eq(dto.getLastName()));
//        }
//
//        if (StringUtils.isNotEmpty(dto.getEmail())) {
//            booleanBuilder.and(user.email.eq(dto.getEmail()));
//        }
//
//        if (ObjectUtils.isNotEmpty(dto.getGender())) {
//            booleanBuilder.and(user.gender.eq(dto.getGender()));
//        }
//
//        if (ObjectUtils.isNotEmpty(dto.getCount())) {
//            booleanBuilder.and(user.count.eq(dto.getCount()));
//        }
//
//        return booleanBuilder;
//    }
//
//}
