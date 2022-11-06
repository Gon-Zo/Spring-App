package com.example.jpa.domain.user;

import com.example.jpa.constant.UserStatus;
import com.example.jpa.domain.Group;
import com.example.jpa.domain.base.AbstractDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends AbstractDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(targetEntity = Group.class)
    @JoinTable(name = "group_users", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Set<Group> groups = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private UserMeta userMeta;

    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private UserFail userFail;

    @Builder
    private User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    @org.springframework.data.annotation.Transient
    public Boolean isActive() {
        return UserStatus.DEFAULT == this.status;
    }
}
