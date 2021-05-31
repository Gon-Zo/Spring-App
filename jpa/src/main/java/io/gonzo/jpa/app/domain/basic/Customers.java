package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.base.Address;
import io.gonzo.jpa.app.domain.base.BaseEntity;
import io.gonzo.jpa.app.domain.base.GenderConverter;
import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "CUSTOMERS")
public class Customers extends BaseEntity {

    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Convert(converter = GenderConverter.class)
    @Column(name = "GENDER", columnDefinition = "char")
    private Gender gender;

    @Column(name = "EMAIL_ADDRESS", nullable = false)
    private String emailAddress;

    @Column(name = "BIRTH_DATE", nullable = false)
    private Instant birthDate;

    private Instant joinDay;

    @Column(name = "LEVEL", nullable = false)
    private Integer level;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;

    @PrePersist
    @PostLoad
    void initialize() {
        this.joinDay = Instant.now();
        this.level = 0;
    }

}
