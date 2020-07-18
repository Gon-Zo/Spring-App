package com.example.springjpa.domain;


import lombok.Getter;
import org.apache.ibatis.annotations.UpdateProvider;

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

    @PostPersist
    protected void onPostPersist() {
        this.createDate = LocalDate.now();
    }

    @UpdateProvider
    protected void onUpdateProvider() {
        this.updateDate = LocalDate.now();
    }

}
