package com.example.app.app.service;

import com.example.app.app.repository.CategoryRepository;
import com.example.app.app.web.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> getCategoryList() {
        List<CategoryDTO> result = repository.findAll().stream()
                .map(category -> CategoryDTO.builder().build().toDTO(category))
                .filter(CategoryDTO::isParent)
                .collect(Collectors.toList());

        return result;
    }

}
