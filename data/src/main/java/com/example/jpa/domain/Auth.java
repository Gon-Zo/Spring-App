package com.example.jpa.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Table
@Entity(name = "auth")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @JsonManagedReference("authName")
    @Column(nullable = false, name = "auth_name")
    private String authName;

    private Auth(String authName) {
        this.authName = authName;
    }

    public static Auth newAuthOf(String authName) {
        return new Auth(authName);
    }
}
