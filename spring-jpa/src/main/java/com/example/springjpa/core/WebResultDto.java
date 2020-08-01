package com.example.springjpa.core;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class WebResultDto {

    private String status;

    private String message;

    @Builder
    public WebResultDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
