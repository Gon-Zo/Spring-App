package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PRODUCT_DETAIL")
public class ProductDetail extends DomainEntity {

    @OneToOne(mappedBy = "productDetail")
    private Product product;

    @Column(name = "discription")
    private String discription;

    @Column(name = "work_name" , nullable = false)
    private String workName;

    @OneToMany(mappedBy = "productDetail")
    private List<Image> images;

}
