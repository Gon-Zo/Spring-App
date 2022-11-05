package com.example.jpa.data.domain;


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

    @Builder
    private Auth(String authName) {
        this.authName = authName;
    }

}
