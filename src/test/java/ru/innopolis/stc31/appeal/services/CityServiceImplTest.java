package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.CityDTOToCity;
import ru.innopolis.stc31.appeal.converters.CityToCityDTO;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.model.entity.City;
import ru.innopolis.stc31.appeal.repository.CityRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Testing CityServiceImpl
 */
@SpringJUnitConfig
class CityServiceImplTest {

    @InjectMocks
    private CityServiceImpl service;

    @Mock
    private CityRepository cityRepository;

    @Spy
    private CityDTOToCity cityDTOToCity;

    @Spy
    private CityToCityDTO cityToCityDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createCity(MockUtils.makeCityDTO()));
        assertDoesNotThrow(() -> service.deleteCity(MockUtils.makeCityDTO()));
        assertDoesNotThrow(() -> service.getCityList());
    }

    @Test
    void getCityList() {
        List<City> cityList = new ArrayList<>();
        for (int count = 1; count < 6; count++){
            cityList.add(new City(count, count * 2, "Capital of " + count));
        }
        when(cityRepository.findAll()).thenReturn(cityList);

        List<CityDTO> cityDTOList = service.getCityList();

        assertEquals(cityList.size(), cityDTOList.size());
        assertEquals(cityList.get(1).getCityName(), cityDTOList.get(1).getCityName());
    }

    @Test
    void createCity() {
        CityDTO cityDTO = new CityDTO(1, 5, "Berlin");
        City city = cityDTOToCity.convert(cityDTO);
        when(cityRepository.save(city)).thenReturn(city);

        assertEquals(service.createCity(cityDTO).getCountryId(), cityDTO.getCountryId());
        assertEquals(service.createCity(cityDTO).getCityName(), cityDTO.getCityName());
    }

    @Test
    void deleteCity() {
        CityDTO cityDTO = MockUtils.makeCityDTO();
        assertEquals(service.deleteCity(cityDTO), true);
        verify(cityRepository).deleteById(any());
    }
}
