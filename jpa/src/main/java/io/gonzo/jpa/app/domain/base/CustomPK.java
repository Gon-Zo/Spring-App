package io.gonzo.jpa.app.domain.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
public class CustomPK implements Serializable {

    private String url;

    private String email;

}
