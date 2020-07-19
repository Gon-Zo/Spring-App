package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class PostSupportImpl extends QuerydslRepositorySupport implements PostSupport{

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public PostSupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Post.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /**
     * Jpql example method
     *
     * @return
     */
    @Override
    public Optional<List<Post>> findByAll() {

        String queryStr = "select * from post";

        Query query = entityManager.createQuery(queryStr);

        List<Post> result = query.getResultList();

        return Optional.ofNullable(result);
    }

}
