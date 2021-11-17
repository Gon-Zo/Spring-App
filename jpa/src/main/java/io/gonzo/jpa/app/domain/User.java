package io.gonzo.jpa.app.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.gonzo.jpa.app.domain.base.BaseEntity;
import io.gonzo.jpa.app.domain.base.Name;
import io.gonzo.jpa.app.enums.Gender;
import io.gonzo.jpa.app.enums.convert.GenderConvert;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "app_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@Convert(converter = GenderConvert.class , attributeName = "gender")
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
    @JoinTable(name = "app_group_app_users",
            joinColumns = @JoinColumn(name = "app_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "app_group_id", referencedColumnName = "id")
    )
    private Set<Group> groups = new HashSet<>();

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


