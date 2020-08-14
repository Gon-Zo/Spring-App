package com.example.springjpa.web.dto;

import com.example.springjpa.domain.category.Category;
import com.example.springjpa.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Create by park031517@gmail.com on 2020-08-14, 금
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@ToString
@NoArgsConstructor
public class ProductDto {

    private String name;

    private BigDecimal price;

    private String image;

    private Boolean isSale;

    private Boolean isDiscount;

    private Category category;

    public Product toEntity (){
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .image(this.image)
                .isSale(this.isSale)
                .isDiscount(this.isDiscount)
                .category(this.category)
                .build();
    }

    public void useSaleToTrue(){
       this.isSale = true;
    }

    public void useSaleToFalse(){
        this.isSale = false;
    }

    public void useDiscountToTrue() {
        this.isDiscount = true;
    }

    public void useDiscountToFalse() {
        this.isDiscount = false;
    }

}
