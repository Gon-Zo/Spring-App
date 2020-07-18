package com.example.springjpa.domain;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "create_date")
    protected LocalDate createDate;

    @Column(name = "update_date")
    protected LocalDate updateDate;

    @PrePersist
    protected void onPrePersist() {
        this.createDate = LocalDate.now();
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.updateDate = LocalDate.now();
    }

}
