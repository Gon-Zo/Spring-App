package io.gonzo.jpa.app.domain.base;

import io.gonzo.jpa.app.enums.Gender;

import javax.persistence.Converter;

@Converter(autoApply = true)
public class GenderConverter extends AbstractBaseEnumConverter<Gender , String> {

    @Override
    protected Gender[] getValueList() {
        return Gender.values();
    }

}
