package com.example.jpa.api.service;

import com.example.jpa.api.service.dto.CategoryDTO;
import com.example.jpa.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO.Info> getCategoryList() {
        return repository.findByParentIsNull(CategoryDTO.Info.class);
    }
}
