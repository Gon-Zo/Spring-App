package com.example.springjpa.web;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.service.post.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by pnw1517@gmail.com on 2020.07.20
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    /**
     * jpa 포스트 데이터 출력
     *
     * @return
     */
    @GetMapping("")
    public List<Post> showPosts() {
        return service.getAllPost();
    }

    @GetMapping("/jpql")
    public List<Post> showPostsByJpql() {
        return service.getAllPostByJpal();
    }

    @GetMapping("jpal")
    public List<Post> showPostsByjpal(String title){
        return service.getPostByJpql(title);
    }

}
