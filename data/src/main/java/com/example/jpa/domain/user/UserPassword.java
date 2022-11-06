package com.example.jpa.domain.user;

import com.example.jpa.domain.base.AbstractDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPassword extends AbstractDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "hash_password")
    private String password;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public UserPassword(String password) {
        this.password = password;
    }
}

