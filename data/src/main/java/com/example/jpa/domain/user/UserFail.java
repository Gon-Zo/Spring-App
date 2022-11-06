package com.example.jpa.domain.user;

import com.example.jpa.domain.base.AbstractDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFail extends AbstractDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count", nullable = false)
    private BigDecimal count;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private User user;


    @PrePersist
    void insert() {
        this.count = Optional.ofNullable(this.count).orElse(BigDecimal.ZERO);
    }
}
