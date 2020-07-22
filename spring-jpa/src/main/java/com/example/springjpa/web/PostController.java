package com.example.springjpa.web;

import com.example.springjpa.domain.post.Post;
import com.example.springjpa.service.post.PostService;
import com.example.springjpa.web.dto.PostDto;
import org.springframework.mobile.device.Device;
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

    /**
     * jpa 포스트 데이터 출력
     *
     * @return
     */
    @GetMapping("")
    public List<Post> showPosts(Device device) {
        return service.getAllPost();
    }

    /**
     * jpql select 절
     * @return
     */
    @GetMapping("/jpql")
    public List<Post> showPostsByJpql() {
        return service.getAllPostByJpal();
    }

    /**
     * jpal select 절 find title
     * @param title
     * @return
     */
    @GetMapping("/jpql/find")
    public List<Post> showPostsByjpal(String title){
        return service.getPostByJpql(title);
    }

    /**
     * 하나의 포스트 업데이트
     *
     * @param seq
     * @param dto
     */
    @PutMapping("/{seq}")
    public void modifyPostInfo (@PathVariable long seq , PostDto dto){
        service.updateToPost(seq, dto);
    }

    /**
     * 하나의 포스트 삭제
     *
     * @param seq
     */
    @DeleteMapping("/{seq}")
    public void removeToPost(@PathVariable long seq){
        service.removeToPost(seq);
    }

    /**
     * 포스트 정보 저장
     *
     * @param dto
     */
    @PostMapping("/")
    public void createPostInfo(PostDto dto){
        service.saveToPost(dto);
    }

}
