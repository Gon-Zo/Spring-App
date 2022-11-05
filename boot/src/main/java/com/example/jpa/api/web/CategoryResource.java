package com.example.jpa.api.web;

import com.example.jpa.api.service.CategoryService;
import com.example.jpa.api.service.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryResource {

    private final CategoryService service;

    @GetMapping("")
    public List<CategoryDTO> showByCategories() {
        return service.getCategoryList();
    }

}
