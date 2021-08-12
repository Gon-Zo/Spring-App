package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.base.AppBaseEntity;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Table(name = "app_product")
@Entity
public class Product extends AppBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_title", nullable = false)
    private String title;

    @Column(name = "product_count")
    private BigDecimal count = new BigDecimal(0);

    @Column(name = "work_id", nullable = false)
    private String workId;

    @OneToOne(targetEntity = BigCategory.class)
    private BigCategory bigCategorySet;

}
