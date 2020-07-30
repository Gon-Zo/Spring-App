package com.example.springjpa.web.dto;

import com.example.springjpa.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Create by park031517@gmail on 2020.07.22
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@ToString
@NoArgsConstructor
public class UserDto {

    private String email;

    private String password;

    private String name;

    private LocalDate createDate;

    public User toEntity (){
        return User.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }

}
