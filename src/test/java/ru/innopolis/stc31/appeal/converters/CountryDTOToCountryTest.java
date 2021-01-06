package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
class CountryDTOToCountryTest {

    @Autowired
    private CountryDTOToCountry countryDTOToCountry;

    @Test
    void convert() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        assertEquals( countryDTOToCountry.convert(countryDTO).getCountryName(), countryDTO.getCountryName());
    }
}