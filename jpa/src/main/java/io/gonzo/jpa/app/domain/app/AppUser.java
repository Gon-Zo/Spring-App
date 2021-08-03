package io.gonzo.jpa.app.domain.app;

import io.gonzo.jpa.app.domain.app.base.AppBaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser extends AppBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "count", nullable = false)
    private BigDecimal count;

    @ManyToMany
    private Set<AppGroup> appGroups = new HashSet<>();

    @Builder
    public AppUser(Long id, String firstName, String lastName, String email, String gender, BigDecimal count) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.count = count;
    }

}


