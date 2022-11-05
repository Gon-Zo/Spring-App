package com.example.app.app.web.dto;

import com.example.app.app.domain.Category;
import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private String title;

    private String workId;

    private Category parent;

    private Set<Category> childrenSet;

    private Instant createDate;

    private Instant updateDate;

    @Builder
    public CategoryDTO(Long id, String title, String workId, Category parent, Set<Category> childrenSet, Instant createDate, Instant updateDate) {
        this.id = id;
        this.title = title;
        this.workId = workId;
        this.parent = parent;
        this.childrenSet = childrenSet;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public CategoryDTO toDTO(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.workId = category.getWorkId();
        this.parent = category.getParent();
        this.childrenSet = category.getChildrenSet();
        this.createDate = category.getCreateDate();
        this.updateDate = category.getUpdateDate();
        return this;
    }

    public boolean isParent() {
        return ObjectUtils.isEmpty(this.parent);
    }

}
