package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.User;
import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserStoreDTO {

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

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
