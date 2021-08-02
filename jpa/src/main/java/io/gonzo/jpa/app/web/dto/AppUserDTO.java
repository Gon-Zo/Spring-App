package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.app.AppUser;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AppUserDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private BigDecimal count;

    public AppUser toEntity() {
        return AppUser.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .gender(this.gender)
                .count(this.count)
                .build();
    }

}
