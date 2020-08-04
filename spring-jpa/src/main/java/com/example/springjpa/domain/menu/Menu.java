package com.example.springjpa.domain.menu;

import com.example.springjpa.domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "APP_MENU")
public class Menu extends BaseEntity {

    @Column(name = "url" , nullable = false)
    private String url;

}
