package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.web.dto.PostDto;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    List<Post> getAllPostByJpal();

    List<Post> getPostByJpql(String title);

    void updateToPost(long seq , PostDto dto);

    void removeToPost(long seq);

    void saveToPost(PostDto dto);

}
