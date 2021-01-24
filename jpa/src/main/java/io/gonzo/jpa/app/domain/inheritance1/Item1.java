package io.gonzo.jpa.app.domain.inheritance1;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
public class Item1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

}
