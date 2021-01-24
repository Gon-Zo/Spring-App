package io.gonzo.jpa.app.domain.inheritance3;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private BigDecimal price;

}
