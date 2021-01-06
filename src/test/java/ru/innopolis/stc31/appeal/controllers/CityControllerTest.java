package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.services.CityService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing CityController
 */
@SpringJUnitConfig
class CityControllerTest {

    @InjectMocks
    private CityController controller;

    @Mock
    private CityService service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllCities());
        assertDoesNotThrow(() -> controller.createCity(new CityDTO()));
    }

    @Test
    void getAllCitiesWithOk() {
        List<CityDTO> cities = MockUtils.makeListCityDTO(5);
        when(service.getCityList()).thenReturn(cities);

        assertEquals(cities.size(), controller.getAllCities().size());
    }

    @Test
    void createCityWithOk() {
        CityDTO city = MockUtils.makeCityDTO();

        when(service.createCity(city)).thenReturn(true);

        assertTrue(controller.createCity(city));
    }
}
