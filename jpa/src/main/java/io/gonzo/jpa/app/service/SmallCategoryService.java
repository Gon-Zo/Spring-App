package io.gonzo.jpa.app.service;

import io.gonzo.jpa.app.domain.SmallCategory;
import io.gonzo.jpa.app.repository.SmallCategoryRepository;
import io.gonzo.jpa.app.web.dto.SmallCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SmallCategoryService {

    private final SmallCategoryRepository repository;

    public List<SmallCategory> batchSave(List<SmallCategoryDTO> dtoList) {
        List<SmallCategory> saveEntities = dtoList.stream().map(SmallCategoryDTO::toEntity).collect(Collectors.toList());
        saveEntities = repository.saveAll(saveEntities);
        return saveEntities;
    }

}
