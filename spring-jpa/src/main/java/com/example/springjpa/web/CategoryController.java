package com.example.springjpa.web;

import com.example.springjpa.domain.category.Category;
import com.example.springjpa.service.category.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/api/app/category")
public class CategoryController {

    private CategoryService service;

    @PostMapping("")
    public void createToCategory(@RequestBody  String name){
       service.saveToCotegory(name);
    }

    @PutMapping("/{seq}")
    public void modifyToCategory(@PathVariable  long seq , @RequestBody String name) {
        service.updateToCategory(seq, name);
    }

    @DeleteMapping("/{seq}")
    public void removeToCategory(@PathVariable long seq){
        service.deleteToCategory(seq);
    }

    @GetMapping("")
    public List<Category> showToCategory() {
        return service.getToCategory();
    }

}
