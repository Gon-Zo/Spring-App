package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.domain.base.Name;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private BigDecimal count;

    public User toEntity() {
        return User.builder()
                .name(Name.builder()
                        .firstName(this.firstName)
                        .lastName(this.lastName)
                        .build())
                .email(this.email)
                .gender(this.gender)
                .count(this.count)
                .build();
    }

}
