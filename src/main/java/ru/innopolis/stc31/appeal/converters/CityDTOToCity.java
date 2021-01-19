package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.City;

@Component
public class CityDTOToCity implements Converter<CityDTO, City> {

    @Override
    public City convert(CityDTO source) {
        City city = new City();
        city.setCountryId(source.getCountryId());
        city.setCityName(source.getCityName());
        return city;
    }
}
