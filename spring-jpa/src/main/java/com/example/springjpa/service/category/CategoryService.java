package com.example.springjpa.service.category;

import com.example.springjpa.domain.category.Category;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface CategoryService {

    void saveToCotegory(String name);

    void updateToCategory(long seq , String name);

    void deleteToCategory(long seq);

    List<Category> getToCategory();

}
