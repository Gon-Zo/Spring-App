package io.gonzo.jpa.app.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "app_auth")
@NoArgsConstructor
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference("authName")
    @Column(nullable = false , name = "auth_name")
    private String authName;

}
