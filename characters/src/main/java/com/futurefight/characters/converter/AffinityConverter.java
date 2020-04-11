package com.futurefight.characters.converter;

import com.futurefight.characters.model.Affinity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class AffinityConverter implements AttributeConverter<Affinity, String> {

    @Override
    public String convertToDatabaseColumn(Affinity category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Affinity convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Affinity.values())
                .filter(c -> c.getValue().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
