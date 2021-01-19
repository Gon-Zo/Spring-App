package io.gonzo.jpa.app.domain;

import io.gonzo.jpa.app.domain.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends DomainEntity {

    private String name;

    @ManyToOne
    private ProductDetail productDetail;

}
