package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class PostSupportImpl extends QuerydslRepositorySupport implements PostSupport{

    public PostSupportImpl() {
        super(Post.class);
    }

}
