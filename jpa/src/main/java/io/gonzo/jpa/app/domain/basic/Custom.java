package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.base.CustomPK;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor
public class Custom {

    @EmbeddedId
    private CustomPK customPK;

    private String content;

    @Builder
    public Custom(CustomPK customPK, String content) {
        this.customPK = customPK;
        this.content = content;
    }

}
