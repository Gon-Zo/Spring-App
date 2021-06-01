package io.gonzo.jpa.app.domain.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Address {

    @Getter
    private String addressCode;

    @Getter
    private String city;

    @Getter
    private Integer addressNumber;

    @Builder
    public Address(String addressCode, String city, Integer addressNumber) {
        this.addressCode = addressCode;
        this.city = city;
        this.addressNumber = addressNumber;
    }
}
