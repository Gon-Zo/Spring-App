package io.gonzo.jpa.app.domain.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class Name {

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Builder
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
