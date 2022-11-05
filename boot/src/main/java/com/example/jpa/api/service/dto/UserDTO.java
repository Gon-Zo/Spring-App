package com.example.jpa.api.service.dto;

import com.example.jpa.data.domain.base.Name;
import com.example.jpa.share.constant.Gender;
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
