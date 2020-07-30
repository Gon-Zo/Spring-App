package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.domain.post.PostRepository;
import com.example.springjpa.domain.post.support.PostSupport;
import com.example.springjpa.web.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by park031517@gmail on 2020.07.20
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
public class PostServiceImpl implements PostService {

    private final PostSupport support;

    private final PostRepository repository;

    public PostServiceImpl(PostSupport support, PostRepository repository) {
        this.support = support;
        this.repository = repository;
    }

    @Override
    public List<Post> getAllPost() {
        return support.findByAll().orElseGet(() -> new ArrayList<>());
    }

    @Override
    public List<Post> getPost(String title) {
        return support.findByTitle(title).orElseGet(() -> new ArrayList<>());
    }

    @Override
    public void updateByPost(long seq, PostDto dto) {
        support.update(seq ,dto);
    }

    @Override
    public void removeByPost(long seq) {
        support.deleteById(seq);
    }

    @Override
    public void createByPost(PostDto dto) {
        repository.save(dto.toEntity());
    }

}
