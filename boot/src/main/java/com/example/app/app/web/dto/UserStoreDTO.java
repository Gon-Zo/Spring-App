package com.example.app.app.web.dto;

import com.example.app.app.domain.User;
import com.example.app.app.domain.base.Name;
import com.example.app.app.enums.Gender;
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
