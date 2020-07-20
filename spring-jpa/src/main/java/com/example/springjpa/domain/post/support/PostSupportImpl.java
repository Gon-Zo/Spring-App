package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    @Transactional(readOnly = true)
    public Optional<List<Post>> findByAll() {

        String queryStr = "select p.title , p.content  from post as p ";

        TypedQuery<Post> query = entityManager.createQuery(queryStr, Post.class);

        List<Post> result = query.getResultList();

        return Optional.ofNullable(result);
    }

    /**
     * jpql 파라미터 사용법
     *
     * @param title
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Post>> findByTitle(String title) {

        String queryStr = "select p.title , p.content from post as p where p.title = :title";

        TypedQuery<Post> query = entityManager.createQuery(queryStr, Post.class);

        query.setParameter("title" , title);

        List<Post> list = query.getResultList();

        return Optional.ofNullable(list);
    }

}
