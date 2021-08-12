package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.base.AppBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

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
