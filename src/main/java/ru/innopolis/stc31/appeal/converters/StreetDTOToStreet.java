package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;

@Component
public class StreetDTOToStreet implements Converter<StreetDTO, Street> {
    @Override
    public Street convert(StreetDTO source) {
        Street street = new Street();
        street.setIdCity(source.getIdCity());
        street.setStreetName(source.getStreetName());
        return street;
    }
}
