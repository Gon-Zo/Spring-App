package io.gonzo.jpa.app.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.gonzo.jpa.app.domain.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "category")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
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
    public Category(Long id, String title, String workId, Category parent, Set<Category> childrenSet) {
        this.id = id;
        this.title = title;
        this.workId = workId;
        this.parent = parent;
        this.childrenSet = childrenSet;
    }

}
