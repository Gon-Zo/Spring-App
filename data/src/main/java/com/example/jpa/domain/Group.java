package com.example.jpa.domain;


import com.example.jpa.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Table
@Entity(name = "groups")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Group extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_title", nullable = false)
    private String title;

    @Column(name = "use_yn", nullable = false)
    private Boolean useYn;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "group_auths", joinColumns = @JoinColumn(name = "group_id"), inverseJoinColumns = @JoinColumn(name = "app_auths_id"))
    private List<Auth> auths = new ArrayList<>();

    @PrePersist
    public void onPrePersist() {
        if (BooleanUtils.isNotTrue(this.useYn)) {
            this.useYn = Boolean.FALSE;
        }
    }
}
