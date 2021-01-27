package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.base.CustomPK;
import io.gonzo.jpa.app.domain.basic.Custom;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomDTO {

    private CustomPK customPK;

    private String content;

    public Custom toEntity() {
        return Custom.builder()
                .customPK(this.customPK)
                .content(this.content)
                .build();
    }

}
