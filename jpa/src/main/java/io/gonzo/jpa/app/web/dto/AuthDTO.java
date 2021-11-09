package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.Auth;
import lombok.*;

@Value
@Getter
@Setter
public class AuthDTO {

    private String authName;

    public Auth toEntity() {
        return Auth.builder()
                .authName(this.authName)
                .build();
    }

}
