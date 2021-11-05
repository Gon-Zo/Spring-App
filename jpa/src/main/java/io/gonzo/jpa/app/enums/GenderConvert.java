package io.gonzo.jpa.app.enums;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.Optional;

public class GenderConvert implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        return Optional.ofNullable(attribute).orElse(Gender.NULL).getValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        if (StringUtils.isEmpty(dbData)) {
            return Gender.NULL;
        }
        return Gender.findOf(dbData);
    }

}
