package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.SmallCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SmallCategoryDTO {

    private String title;

    private String workId;

    public SmallCategory toEntity() {
        return SmallCategory.builder()
                .title(this.title)
                .workId(this.workId)
                .build();
    }

}
