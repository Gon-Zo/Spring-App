package io.gonzo.jpa.app.domain.app;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "app_auth")
@NoArgsConstructor
public class AppAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authName;

}
