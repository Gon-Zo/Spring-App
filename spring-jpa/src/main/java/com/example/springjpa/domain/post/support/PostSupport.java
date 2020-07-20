package com.example.springjpa.domain.post.support;

import com.example.springjpa.domain.post.Post;

import java.util.List;
import java.util.Optional;

public interface PostSupport {

    Optional<List<Post>> findByAll();

    Optional<List<Post>> findByTitle(String title);

}
