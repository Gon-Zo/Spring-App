package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    List<Post> getAllPostByJpal();

    List<Post> getPostByJpql(String title);

}
