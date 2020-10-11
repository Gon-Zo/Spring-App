package com.example.springjpa.service;

import com.example.springjpa.domain.Category;
import com.example.springjpa.repository.CategoryRepository;
import com.example.springjpa.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-10-10, 토
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    public List<Category> getToCategoryList(){
        return categoryRepository.findAll();
    }

}
