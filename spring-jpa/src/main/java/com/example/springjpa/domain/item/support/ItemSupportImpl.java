package com.example.springjpa.domain.item.support;

import com.example.springjpa.domain.item.Item;
import com.example.springjpa.web.dto.PageDto;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.springjpa.domain.item.QItem.item;

/**
 * Create by park031517@gmail.com on 2020-08-15, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public class ItemSupportImpl extends QuerydslRepositorySupport implements ItemSupport {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public ItemSupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Item.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Item> findByAll(PageDto pageDto) {

        JPAQuery<Item> query = jpaQueryFactory.selectFrom(item);

        Pageable pageable = PageRequest.of(pageDto.getPage() , pageDto.getSize());

        query.offset(pageable.getOffset()).limit(pageable.getPageSize());

        QueryResults<Item> fetchResults = query.fetchResults();

        long total = fetchResults.getTotal();

        List<Item> results = fetchResults.getResults();

        return new PageImpl<>(results  , pageable , total);
    }


}
