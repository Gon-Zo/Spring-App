package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT")
public class Product extends DomainEntity {

    @Column(name = "TYPE" , nullable = false)
    private String type;

    @Column(name = "NAME" , nullable = false)
    private String name;

    @Column(name = "PRICE" , nullable = false)
    private BigDecimal price;

    @Column(name = "IMG")
    private String img;

    @ManyToOne
    private ProductType productType;

}
