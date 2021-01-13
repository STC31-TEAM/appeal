package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;

@Component
public class CountryDTOToCountry implements Converter <CountryDTO, Country>{
    @Override
    public Country convert(CountryDTO source) {
        Country country = new Country();
        country.setCountryName(source.getCountryName());
        return country;
    }
}
