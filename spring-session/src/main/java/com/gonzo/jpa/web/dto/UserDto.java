package com.gonzo.jpa.web.dto;

import com.gonzo.jpa.domain.user.User;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String email;

    private String password;

    public User toEntity(){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

    public void encodingByPassword(){
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

}
