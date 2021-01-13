package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles({"test"})
class CountryToCountryDTOTest {

    @Autowired
    private CountryDTOToCountry countryDTOToCountry;

    @Autowired
    private CountryToCountryDTO countryToCountryDTO;

    @Test
    void convert() {
        Country country = countryDTOToCountry.convert(MockUtils.makeCountryDTO());
        assertEquals( countryToCountryDTO.convert(country).getCountryName(), country.getCountryName());
    }
}