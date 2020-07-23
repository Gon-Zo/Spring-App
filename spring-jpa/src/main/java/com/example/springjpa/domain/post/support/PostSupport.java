package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.web.dto.PostDto;

import java.util.List;
import java.util.Optional;

/**
 * Create by pnw1517@gmail.com on 2020.07.18
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface PostSupport {

    Optional<List<Post>> findByAll();

    Optional<List<Post>> findByTitle(String title);

    void update(long seq , PostDto dto);

    void deleteById(long seq);

    void save(PostDto dto);

}
