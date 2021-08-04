package io.gonzo.jpa.app.domain.app;

import io.gonzo.jpa.app.domain.app.base.AppBaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
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

    @PrePersist
    public void prePersist() {

        if (StringUtils.isEmpty(this.firstName)) {
            this.firstName = null;
        }

        if (StringUtils.isEmpty(this.lastName)) {
            this.lastName = null;
        }

        if (StringUtils.isEmpty(this.email)) {
            this.email = null;
        }

        if (StringUtils.isEmpty(this.gender)) {
            this.gender = null;
        }

        if (ObjectUtils.isEmpty(this.count)) {
            this.count = null;
        }
    }


}


