package com.example.jpa.api.service.dto;

import com.example.jpa.data.domain.User;
import com.example.jpa.data.domain.base.Name;
import com.example.jpa.share.constant.Gender;
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
