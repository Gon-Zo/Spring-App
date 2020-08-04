package com.example.springjpa.domain.user;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.group.Group;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Entity
@Table(name = "APP_USER")
@NoArgsConstructor
public class User extends BaseEntity {

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column( name = "name", nullable = false)
    private String name;

    @OneToMany
    private List<Group> groups;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

}
