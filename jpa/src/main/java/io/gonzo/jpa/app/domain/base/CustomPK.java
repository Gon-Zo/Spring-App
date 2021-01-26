package io.gonzo.jpa.app.domain.base;

import lombok.Getter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class CustomPK implements Serializable {

    private String url;

    private String email;

}
