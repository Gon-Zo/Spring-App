package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.web.dto.PostDto;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    List<Post> getPost(String title);

    void updateByPost(long seq , PostDto dto);

    void removeByPost(long seq);

    void createByPost(PostDto dto);

}
