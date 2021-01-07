package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing CityServiceImpl
 */
@SpringJUnitConfig
class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createCity(MockUtils.makeCityDTO()));
        assertDoesNotThrow(() -> service.deleteCity(MockUtils.makeCityDTO()));
        assertDoesNotThrow(() -> service.getCityList());
    }
}
