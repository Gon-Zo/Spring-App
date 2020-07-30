package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.web.dto.PostDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Create by park031517@gmail on 2020.07.18
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

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Post>> findByAll() {

        String queryStr = "select p from Post p ";

        TypedQuery query = entityManager.createQuery(queryStr, Post.class);

        List<Post> result = query.getResultList();

        entityManager.close();

        return Optional.ofNullable(result);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<Post>> findByTitle(String title) {

        String queryStr = "select p from Post p where p.title = :title";

        TypedQuery<Post> query = entityManager.createQuery(queryStr, Post.class);

        query.setParameter("title", title);

        entityManager.close();

        List<Post> list = query.getResultList();

        return Optional.ofNullable(list);

    }

    @Override
    @Transactional
    public void update( long seq, PostDto dto) {

        StringBuffer str = new StringBuffer();

        str.append("Update Post p");

        if(isNotEmpty(dto.getTitle())){
            str.append("set p.title = :title");
        }

        if(isNotEmpty(dto.getContent())){
            str.append(",set p.content = :content");
        }

        str.append("where p.seq =:seq");

        Query query = entityManager.createQuery(str.toString());

        if(isNotEmpty(dto.getTitle())){
            query.setParameter("title" , dto.getTitle());
        }

        if(isNotEmpty(dto.getContent())){
            query.setParameter("content" , dto.getContent());
        }

        query.setParameter("seq" , seq);

        query.executeUpdate();

        entityManager.getTransaction();

        entityManager.close();
    }

    @Override
    @Transactional
    public void deleteById(long seq) {
        String str = "DELETE FROM Post p WHERE p.seq =:seq";

        Query query = entityManager.createQuery(str);

        query.setParameter("seq" , seq);

        entityManager.getTransaction();

        entityManager.close();
    }

}
