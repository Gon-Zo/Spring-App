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

/**
 * 서비스를 위한 User 엔티티
 *
 * @author newbalancer
 * @see com.example.jpa.repository.UserRepository
 */
@Getter
@DynamicInsert
@DynamicUpdate
@Entity(name = "users")
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

    @JsonIgnore
    @ManyToMany(targetEntity = Group.class)
    @JoinTable(name = "group_users", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"))
    private Set<Group> groups = new HashSet<>();

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private UserMeta userMeta;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private UserFail userFail;

    @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private UserPassword userPassword;

    @org.springframework.data.annotation.Transient
    public Boolean isActive() {
        return UserStatus.DEFAULT == this.status;
    }

    @org.springframework.data.annotation.Transient
    public void setDefaultStatus() {
        this.status = UserStatus.DEFAULT;
    }

    @Builder
    private User(String email, UserStatus status, UserMeta userMeta, UserFail userFail, UserPassword userPassword) {
        this.email = email;
        this.status = status;
        this.userMeta = userMeta;
        this.userFail = userFail;
        this.userPassword = userPassword;
    }
}
