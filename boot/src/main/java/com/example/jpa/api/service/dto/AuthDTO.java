package com.example.jpa.app.service.dto;

import com.example.jpa.app.domain.Auth;
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
