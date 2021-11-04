package io.gonzo.jpa.app.enums;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

public class GenderConvert implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        if (ObjectUtils.isEmpty(attribute)) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        if (StringUtils.isEmpty(dbData)) {
            return Gender.NULL;
        }
        return Gender.valueOf(dbData);
    }

}
