package io.gonzo.jpa.app.domain.basic;

import io.gonzo.jpa.app.domain.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "OrderDetail")
public class OrderDetail extends DomainEntity {

   @OneToOne
   private Orders orders;

   @OneToOne
   private Product product;

   @Column(name = "ORDER_PRODUCT_PRICE" , nullable = false)
   private BigDecimal orderProductPrice;

   @Column(name = "ORDER_CHECK" , nullable = false)
   private BigDecimal orderCheck;

   @Column(name = "ORDER_PRODUCT_QUANTITY" , nullable = false)
   private BigDecimal orderProductQuantity;

}
