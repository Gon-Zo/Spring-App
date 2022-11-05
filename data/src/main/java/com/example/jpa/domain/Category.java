package com.example.jpa.domain;

import com.example.jpa.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Entity(name = "category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category")
public class Category extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(nullable = false)
    private String workId;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private Set<Category> childrenSet = new HashSet<>();

    @Builder
    private Category(Long id, String title, String workId, Category parent, Set<Category> childrenSet) {
        this.id = id;
        this.title = title;
        this.workId = workId;
        this.parent = parent;
        this.childrenSet = childrenSet;
    }
}
