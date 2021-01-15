package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.entity.City;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class CityToCityDTOTest {

    @InjectMocks
    private CityToCityDTO cityToCityDTO;

    @Test
    void convert() {
        City city = new City(3, 5, "Berlin");

        assertEquals(cityToCityDTO.convert(city).getId(), city.getId());
        assertEquals(cityToCityDTO.convert(city).getCountryId(), city.getCountryId());
        assertEquals(cityToCityDTO.convert(city).getCityName(), city.getCityName());
    }
}