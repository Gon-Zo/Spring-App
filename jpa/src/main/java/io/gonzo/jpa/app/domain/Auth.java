package io.gonzo.jpa.app.domain;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "app_auth")
@NoArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authName;

}
