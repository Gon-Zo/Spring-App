package com.example.jpa.app.domain;

import com.example.jpa.app.domain.base.BaseEntity;
import com.example.jpa.app.domain.base.Name;
import com.example.jpa.app.constant.Gender;
import com.example.jpa.app.constant.convert.GenderConvert;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Convert(converter = GenderConvert.class, attributeName = "gender")
public class User extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Convert(converter = GenderConvert.class)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "count", nullable = false)
    private BigDecimal count;

    @ManyToMany(targetEntity = Group.class)
    @JoinTable(name = "group_users", joinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "app_group_id", referencedColumnName = "id"))
    private Set<Group> groups = new HashSet<>();

    @Column
    private Instant birthDate;

    @Column(nullable = false)
    @ColumnDefault(value = "false")
    private Boolean useYn;

    @Builder
    public User(Long id, Name name, String email, Gender gender, BigDecimal count, String password, Boolean useYn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.count = count;
        this.password = password;
        this.useYn = useYn;
    }

    public void usedByUser() {
        this.useYn = Boolean.TRUE;
    }

}
