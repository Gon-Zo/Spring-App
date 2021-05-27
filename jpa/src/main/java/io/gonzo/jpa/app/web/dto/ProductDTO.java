package io.gonzo.jpa.app.web.dto;

import io.gonzo.jpa.app.domain.basic.Product;
import io.gonzo.jpa.app.domain.basic.ProductType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {

    private String type;

    private String name;

    private BigDecimal price;

    private String img;

    private ProductType productType;

    @Builder
    public ProductDTO(String type, String name, BigDecimal price, String img, ProductType productType) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.img = img;
        this.productType = productType;
    }

    public Product toEntity() {
        return Product.builder()
                .type(this.type)
                .name(this.name)
                .price(this.price)
                .img(this.img)
                .productType(this.productType)
                .build();
    }

}
