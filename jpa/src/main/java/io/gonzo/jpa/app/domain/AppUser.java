package io.gonzo.jpa.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @Builder
    public AppUser(Long id, String firstName, String lastName, String email, String gender, BigDecimal count, Instant createDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.count = count;
        this.createDate = createDate;
    }

}


