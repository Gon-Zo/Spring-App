package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.common.BaseEntity;
import io.gonzo.jpa.app.domain.common.GenderConverter;
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

    @Column( name = "ID", nullable = false)
    private String id;

    @Column(name = "PASSWORD" , nullable = false)
    private String password;

    @Column(name = "NAME" , nullable = false)
    private String name;

    @Column(name = "ADDRESS" , nullable = false)
    private String address;

    @Column(name = "PHONE_NUMBER" , nullable = false)
    private String phoneNumber;

    @Convert(converter = GenderConverter.class)
    @Column( name = "GENDER", columnDefinition = "char")
    private Gender gender;

    @Column(name = "EMAIL_ADDRESS" , nullable = false)
    private String emailAddress;

    @Column(name = "BIRTH_DATE" , nullable = false)
    private Instant birthDate;

    private Instant joinDay;

    @Column(name = "LEVEL" , nullable = false)
    private Integer level;

    @OneToMany(mappedBy = "customers")
    private List<Orders> orders;

    @PrePersist
    @PostLoad
    void initialize() {
        this.joinDay = Instant.now();
        this.level = 0;
    }

}
