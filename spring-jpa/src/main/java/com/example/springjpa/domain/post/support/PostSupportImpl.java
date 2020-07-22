package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.web.dto.PostDto;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static com.example.springjpa.domain.post.QPost.post;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;


/**
 * Create by pnw1517@gmail.com on 2020.07.18
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
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

        String queryStr = "select p from Post p ";

        TypedQuery query = entityManager.createQuery(queryStr, Post.class);

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

        String queryStr = "select p from Post p where p.title = :title";

        TypedQuery<Post> query = entityManager.createQuery(queryStr, Post.class);

        query.setParameter("title", title);

        List<Post> list = query.getResultList();

        return Optional.ofNullable(list);

    }

    /**
     * querydsl update 쿼리
     *
     * @param seq
     * @param dto
     */
    @Override
    @Transactional
    public void update(long seq, PostDto dto) {

        UpdateClause<JPAUpdateClause> query = update(post);

        if (isNotEmpty(dto.getTitle())) {
            query.set(post.title, dto.getTitle());
        }

        if(isNotEmpty(dto.getContent())){
           query.set(post.content , dto.getContent());
        }

        query.execute();

    }

}
