package com.example.springjpa.domain.group;

import com.example.springjpa.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "APP_GROUP")
public class Group extends BaseEntity {

    @Column(name = "title" , nullable = false)
    private String title;

    @Builder
    public Group(String title){
        this.title = title;
    }

}
