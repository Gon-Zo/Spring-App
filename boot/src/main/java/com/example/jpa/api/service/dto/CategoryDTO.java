package com.example.jpa.api.service.dto;

import com.example.jpa.domain.Category;
import org.apache.commons.lang3.ObjectUtils;

import java.time.Instant;

public class CategoryDTO {

    public interface Info {

        Long getId();

        String getTitle();

        String getWorkId();

        Category getParent();

        Category getCildrenSet();

        Instant getCreateDate();

        Instant getUpdateDate();

        default Boolean isParent() {
            return ObjectUtils.isEmpty(getParent());
        }
    }
}
