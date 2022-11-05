package com.example.jpa.share.constant.convert;

import com.example.jpa.share.constant.Gender;

import javax.persistence.AttributeConverter;
import java.util.Optional;

public class GenderConvert implements AttributeConverter<Gender, String> {

    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        return Optional.ofNullable(attribute).orElse(Gender.NULL).getValue();
    }

    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return Gender.findOf(dbData);
    }

}
