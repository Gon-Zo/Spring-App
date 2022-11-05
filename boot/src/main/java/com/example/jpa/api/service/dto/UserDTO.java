package com.example.jpa.app.service.dto;

import com.example.jpa.app.domain.base.Name;
import com.example.jpa.app.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private Name name;

    private String email;

    private Gender gender;

    private BigDecimal count;

}
