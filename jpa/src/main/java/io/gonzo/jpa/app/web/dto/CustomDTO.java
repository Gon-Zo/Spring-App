package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomDTO {

    private CustomPK customPK;

    private String content;

    @Builder
    public CustomDTO(CustomPK customPK, String content) {
        this.customPK = customPK;
        this.content = content;
    }

    public Custom toEntity() {
        return Custom.builder()
                .customPK(this.customPK)
                .content(this.content)
                .build();
    }

}
