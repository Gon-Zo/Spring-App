package io.gonzo.jpa.app.domain.base;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String addressCode;

    private String city;

    private Integer addressNumber;

}
