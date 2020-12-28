package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;

@Component
public class StreetToStreetDTO implements Converter<Street, StreetDTO> {
    @Override
    public StreetDTO convert(Street source) {
        StreetDTO streetDTO = new StreetDTO();
        streetDTO.setId(source.getId());
        streetDTO.setIdCity(source.getIdCity());
        streetDTO.setStreetName(source.getStreetName());
        return streetDTO;
    }
}
