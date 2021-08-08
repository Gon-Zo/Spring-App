package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.enums.Gender;
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
