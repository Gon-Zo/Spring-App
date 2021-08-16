package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.Category;
import io.gonzo.jpa.app.service.CategoryService;
import io.gonzo.jpa.app.web.dto.CategoryDTO;
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
    public List<CategoryDTO> showByCategories(){
        return service.getCategoryList();
    }

}
