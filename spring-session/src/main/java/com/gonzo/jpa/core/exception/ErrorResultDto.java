package com.gonzo.jpa.core.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResultDto {

    private String code;

    private String message;

    @Builder
    public ErrorResultDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
