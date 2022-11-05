package com.example.jpa.app.domain;

import com.example.jpa.app.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Table
@Entity(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_title", nullable = false)
    private String title;

    @Column(name = "product_count")
    private BigDecimal count = new BigDecimal(0);

    @Column(name = "work_id", nullable = false)
    private String workId;

    @OneToOne(targetEntity = Category.class)
    private Category categorySet;

    @Builder
    private Product(Long id, String title, BigDecimal count, String workId, Category categorySet) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.workId = workId;
        this.categorySet = categorySet;
    }
}
