package com.example.springjpa.web;

import com.example.springjpa.domain.Category;
import com.example.springjpa.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-10-10, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostResource {

    private final PostService service;

    @GetMapping("/category")
    public List<Category> shoToCategoryList(){
        return service.getToCategoryList();
    }

    @GetMapping("/post/title")
    public List<String> showToTitleGroup(){
        return service.getToGroupByTitle();
    }

}
