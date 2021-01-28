package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.CityDTOToCity;
import ru.innopolis.stc31.appeal.converters.CityToCityDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.City;
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

    @Spy
    private CityDTOToCity cityDTOToCity;

    @Spy
    private CityToCityDTO cityToCityDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllCities());
        assertDoesNotThrow(() -> controller.createCity(MockUtils.makeCityDTO()));
    }

    @Test
    void getAllCitiesWithOk() {
        List<CityDTO> cities = MockUtils.makeListCityDTO(5);
        when(service.getCityList()).thenReturn(cities);

        assertEquals(cities.size(), controller.getAllCities().size());
    }

    @Test
    void createCity() {
        CityDTO cityDTO = new CityDTO(3, 4, "London");
        City city = cityDTOToCity.convert(cityDTO);
        when(service.createCity(cityDTO)).thenReturn(city);

        ResponseEntity<CityDTO> responseEntity = controller.createCity(cityDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(cityDTO.getCountryId(), responseEntity.getBody().getCountryId());
        assertEquals(cityDTO.getCityName(), responseEntity.getBody().getCityName());
    }

    @Test
    void deleteCityWithOk() {
        CityDTO cityDTO = MockUtils.makeCityDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(service.deleteCity(cityDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteCity(cityDTO);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(successModel.getResult(),responseEntity.getBody().getResult());
    }

    @Test
    void deleteCityWithFail() {
        CityDTO cityDTO = MockUtils.makeCityDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(service.deleteCity(cityDTO)).thenReturn(false);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteCity(cityDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }
}
