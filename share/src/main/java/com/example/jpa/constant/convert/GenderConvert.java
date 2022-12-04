package com.example.jpa.constant.convert;

import com.example.jpa.constant.Gender;

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
