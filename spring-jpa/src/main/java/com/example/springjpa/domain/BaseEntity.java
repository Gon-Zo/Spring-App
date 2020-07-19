package com.example.springjpa.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq" , nullable = false)
    private Long seq;

    @Column(name = "create_date" , nullable = false)
    protected LocalDate createDate;

    @Column(name = "update_date" , nullable = false)
    protected LocalDate updateDate;

    @PrePersist
    protected void onPrePersist(){
        this.createDate = this.updateDate = LocalDate.now();
    }

    @PreUpdate
    protected void onPreUpdate() {
        this.updateDate = LocalDate.now();
    }

}
