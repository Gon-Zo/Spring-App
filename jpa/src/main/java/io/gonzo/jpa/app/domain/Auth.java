package io.gonzo.jpa.app.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_auth")
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @JsonManagedReference("authName")
    @Column(nullable = false, name = "auth_name")
    private String authName;

    @Builder
    public Auth(String authName) {
        this.authName = authName;
    }

}
