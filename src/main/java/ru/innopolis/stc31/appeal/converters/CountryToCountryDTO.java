package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;

@Component
public class CountryToCountryDTO implements Converter<Country, CountryDTO> {

    @Override
    public CountryDTO convert(Country source) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(source.getId());
        countryDTO.setCountryName(source.getCountryName());
        return countryDTO;
    }
}
