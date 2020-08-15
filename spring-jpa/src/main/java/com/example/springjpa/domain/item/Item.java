package com.example.springjpa.domain.item;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.category.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@Entity
@NoArgsConstructor
@Table(name = "APP_Item")
public class Item extends BaseEntity {

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "price" , nullable = false)
    private BigDecimal price;

    @Column(name = "image" , nullable = false)
    private String image;

    @Setter
    @Column(name = "is_sale" , nullable = false)
    private Boolean  isSale;

    @Setter
    @Column(name = "is_discount" , nullable = false)
    private Boolean isDiscount;

    @OneToOne
    private Category category;

    @Builder
    public Item(String name,
                BigDecimal price,
                String image,
                Boolean isSale,
                Boolean isDiscount,
                Category category) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.isSale = isSale;
        this.isDiscount = isDiscount;
        this.category = category;
    }

}
