package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.City;

@Component
public class CityToCityDTO implements Converter<City, CityDTO> {
    @Override
    public CityDTO convert(City source) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(source.getId);
        cityDTO.setCountryId(source.getCountryId());
        cityDTO.setCityName(source.getCityName());
        return cityDTO;
    }
}
