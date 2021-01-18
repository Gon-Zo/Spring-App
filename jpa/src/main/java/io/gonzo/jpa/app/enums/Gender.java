package io.gonzo.jpa.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender implements BaseEnumCode<String> {

    NULL(""),
    WOMAN("W"),
    MAN("M");

    private final String value;

}
