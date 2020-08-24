package com.gonzo.jpa.core.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class AuthResultDto {

    private String state;

    private String message;

    @Builder
    public AuthResultDto(String state, String message) {
        this.state = state;
        this.message = message;
    }

}
