package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.base.DomainEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "ITEM")
public class Item extends DomainEntity {

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "DESCRIPTION" , nullable = false)
    private String description;

    @Column(name = "UNIT_PRICE", nullable = false)
    private BigDecimal unitPrice;

}
