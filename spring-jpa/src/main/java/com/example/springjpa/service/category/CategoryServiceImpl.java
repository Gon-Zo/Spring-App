package com.example.springjpa.service.category;

import com.example.springjpa.domain.category.Category;
import com.example.springjpa.domain.category.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public void saveToCotegory(String name) {
        categoryRepository.save(Category.builder()
                .name(name)
                .build());
    }

    @Override
    @Transactional
    public void updateToCategory(long seq, String name) {
        Category category = categoryRepository.getOne(seq);
        category.setName(name);
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteToCategory(long seq) {
        categoryRepository.deleteById(seq);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getToCategory() {
        return categoryRepository.findAll();
    }

}
