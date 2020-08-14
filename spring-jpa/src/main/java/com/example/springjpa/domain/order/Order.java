package com.example.springjpa.domain.order;

import com.example.springjpa.domain.BaseEntity;
import com.example.springjpa.domain.product.Product;
import com.example.springjpa.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
@Entity
@Getter
@NoArgsConstructor
@Table(name = "APP_ORDER")
public class Order extends BaseEntity {

    @OneToOne
    private User user;

    @OneToOne
    private Product product;

    @Column(name = "count" , nullable = false)
    private BigDecimal count;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "state" , nullable = false)
    private String state;

    @Column(name = "is_delete" , nullable = false)
    private Boolean isDelete;

}
