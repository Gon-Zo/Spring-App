package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.base.DomainEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product extends DomainEntity {

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;

    @Column(name = "IMG")
    private String img;

    @Getter
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductType productType;

    @Builder
    public Product(String type, String name, BigDecimal price, String img, ProductType productType) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.img = img;
        this.productType = productType;
    }

}
