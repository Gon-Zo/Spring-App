package com.gonzo.jpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
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
