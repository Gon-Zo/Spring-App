package com.example.springjpa.web;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.service.post.PostService;
import com.example.springjpa.web.dto.PostDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by pnw1517@gmail.com on 2020.07.20
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/app/post")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping("/jpql")
    public List<Post> showPosts() {
        return service.getAllPost();
    }

    @GetMapping("/jpql/find")
    public List<Post> showPosts(String title){
        return service.getPost(title);
    }

    @PostMapping("")
    public void saveByPost(@RequestBody PostDto dto){
        service.createByPost(dto);
    }

    @PutMapping("/{seq}")
    public void modifyByPost(@PathVariable long seq  , PostDto dto){
        service.updateByPost(seq , dto);
    }

    @DeleteMapping("/{seq}")
    public void removeByPost(long seq){
        service.removeByPost(seq);
    }

}
