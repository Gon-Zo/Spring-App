package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.base.AppBaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "small_category")
public class SmallCategory extends AppBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sm_title")
    private String title;

    @Column(nullable = false)
    private String workId;

}
