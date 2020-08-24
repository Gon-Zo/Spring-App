package com.gonzo.jpa.domain.user;

import com.gonzo.jpa.domain.BaseEntity;
import com.gonzo.jpa.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "TEST_USER")
public class User extends BaseEntity {

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "password" , nullable = false)
    private String password;

    @OneToMany
    private List<Member> members;

    @Builder
    public User(String email , String password) {
       this.email = email ;
       this.password = password;
    }

}
