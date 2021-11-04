package io.gonzo.jpa.app.enums;

import lombok.Getter;

@Getter
public enum Gender implements BaseEnumCode<String> {

    NULL("빈값", ""),
    WOMAN("여자", "W"),
    MAN("남자", "M");

    private final String desc;

    private final String value;

    Gender(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

}
