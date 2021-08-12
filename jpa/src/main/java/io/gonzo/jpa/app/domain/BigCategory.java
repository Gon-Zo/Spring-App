package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.base.AppBaseEntity;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Table(name = "big_category")
public class BigCategory extends AppBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "big_title", nullable = false)
    private String title;

    @Column(nullable = false)
    private String workId;

    @OneToMany(targetEntity = SmallCategory.class)
    private Set<SmallCategory> smallCategory = new HashSet<>();

    @Builder
    public BigCategory(Long id, String title, String workId) {
        this.id = id;
        this.title = title;
        this.workId = workId;
    }

}
