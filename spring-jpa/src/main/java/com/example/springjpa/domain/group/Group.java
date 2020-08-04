package com.example.springjpa.domain.group;

import com.example.springjpa.domain.BaseEntity;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "APP_GROUP")
public class Group extends BaseEntity {

    @Column(name = "title" , nullable = false)
    private String title;

}
