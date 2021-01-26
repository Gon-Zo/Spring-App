package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.base.CustomPK;
import lombok.Getter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity
public class Custom {

    @EmbeddedId
    private CustomPK customPK;

    private String content;

}
