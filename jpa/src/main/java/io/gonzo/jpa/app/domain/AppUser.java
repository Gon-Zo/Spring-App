package io.gonzo.jpa.app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "app_user")
public class AppUser {

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

    @CreatedDate
    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Instant createDate;

    @UpdateTimestamp
    @LastModifiedDate
    @Column(name = "update_date")
    private Instant updateDate;

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


