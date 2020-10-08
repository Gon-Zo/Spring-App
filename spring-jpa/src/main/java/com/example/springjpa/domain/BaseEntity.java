package com.example.springjpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Create by park031517@gmail.com on 2020-07-30, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Setter
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false , nullable = false)
    protected LocalDate createDate;

    @Column(nullable = false)
    protected LocalDate updateDate;

    @PrePersist
    protected void onPersist() {
        this.createDate = this.updateDate = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDate.now();
    }

}
