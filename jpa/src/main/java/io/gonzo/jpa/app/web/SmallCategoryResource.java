package io.gonzo.jpa.app.web;

import io.gonzo.jpa.app.domain.SmallCategory;
import io.gonzo.jpa.app.service.SmallCategoryService;
import io.gonzo.jpa.app.web.dto.SmallCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/small-category")
public class SmallCategoryResource {

    private final SmallCategoryService service;

    @PostMapping("")
    public List<SmallCategory> createBySmallCategory(@RequestBody List<SmallCategoryDTO> dtoList) {
        return service.batchSave(dtoList);
    }

}
