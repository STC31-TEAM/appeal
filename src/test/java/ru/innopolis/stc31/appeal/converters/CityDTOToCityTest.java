package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.City;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class CityDTOToCityTest {

    @InjectMocks
    private CityDTOToCity cityDTOToCity;

    @Test
    void convert() {
        CityDTO cityDTO = new CityDTO(6, 9, "Paris");

        assertEquals(cityDTOToCity.convert(cityDTO).getCountryId(), cityDTO.getCountryId());
        assertEquals(cityDTOToCity.convert(cityDTO).getCityName(), cityDTO.getCityName());
    }
}