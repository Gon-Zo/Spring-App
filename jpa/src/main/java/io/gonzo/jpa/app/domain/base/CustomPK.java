package io.gonzo.jpa.app.domain.base;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CustomPK implements Serializable {

    private String url;

    private String email;

}
