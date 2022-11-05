package com.example.jpa.api.service.dto;

import com.example.jpa.domain.Auth;
import lombok.*;

@Value
@Getter
@Setter
public class AuthDTO {

    private String authName;

    public Auth toEntity() {
        return Auth.builder()
                .authName(this.authName)
                .build();
    }


    public interface IOnlyAuthName {
        String getAuthName();
    }

}
