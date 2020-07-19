package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.domain.post.PostRepository;
import com.example.springjpa.domain.post.support.PostSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl  implements PostService{

    private final PostSupport support;

    private final PostRepository repository;

    public PostServiceImpl(PostSupport support, PostRepository repository) {
        this.support = support;
        this.repository = repository;
    }

    /**
     * 전체 데이터 출력
     *
     * @return
     */
    @Override
    public List<Post> getAllPost() {
        return repository.findAllBy();
    }

}
