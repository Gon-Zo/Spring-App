package com.example.springjpa.service.post;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.domain.post.PostRepository;
import com.example.springjpa.domain.post.support.PostSupport;
import com.example.springjpa.web.dto.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by pnw1517@gmail.com on 2020.07.20
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

    /**
     * 전체 데이터 출력
     *
     * @return
     */
    @Override
    public List<Post> getAllPost() {
        return repository.findAllBy();
    }

    /**
     * 전체 데이터 훌력 (jpal)
     *
     * @return
     */
    @Override
    public List<Post> getAllPostByJpal() {
        return support.findByAll().orElseGet(() -> new ArrayList<>());
    }

    /**
     * title 이 같은 것만 출력 (jpql)
     *
     * @param title
     * @return
     */
    @Override
    public List<Post> getPostByJpql(String title) {
        return support.findByTitle(title).orElseGet(() -> new ArrayList<>());
    }

    /**
     * update query
     *
     * @param seq
     * @param dto
     */
    @Override
    public void updateToPost(long seq, PostDto dto) {
        support.update(seq , dto);
    }

    /**
     * delete query
     *
     * @param seq
     */
    @Override
    @Transactional
    public void removeToPost(long seq) {
        repository.deleteById(seq);
    }

    /**
     * update query
     *
     * @param dto
     */
    @Override
    public void saveToPost(PostDto dto) {
        repository.save(dto.toEntity());
    }

}
