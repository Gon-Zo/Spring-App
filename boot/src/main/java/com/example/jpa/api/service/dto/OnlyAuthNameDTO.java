package com.example.jpa.app.service.dto;

import lombok.Getter;

public class OnlyAuthNameDTO {

    @Getter
    private final String authName;

    public OnlyAuthNameDTO(String authName) {
        this.authName = authName;
    }

}