package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.converters.CountryDTOToCountry;
import ru.innopolis.stc31.appeal.converters.CountryToCountryDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.repository.CountryRepository;
import ru.innopolis.stc31.appeal.services.CountryService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
class CountryControllerTest {

    @Spy
    private CountryService countryService;

    @Spy
    private CountryRepository countryRepository;

    @Spy
    private CountryDTOToCountry countryDTOToCountry;

    @Spy
    private CountryToCountryDTO countryToCountryDTO;

    @InjectMocks
    private CountryController countryController;

    @Test
    void all() {
        List<CountryDTO> countryDTOList = MockUtils.makeListCountryDTO(4);
        when(countryService.getCountryList()).thenReturn(countryDTOList);

        assertEquals(countryDTOList.size(), countryController.getAllCountries().size());
        assertEquals(countryDTOList.get(1).getCountryName(), countryController.getAllCountries().get(1).getCountryName());
    }

    @Test
    void createWithOk() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        Country country = countryDTOToCountry.convert(countryDTO);
        country.setId(1);
        when(countryService.createCountry(countryDTO)).thenReturn(country);

        ResponseEntity<CountryDTO> responseEntity = countryController.createCountry(countryDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getCountryName(), countryDTO.getCountryName());

    }

    @Test
    void createWithFail() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        Country country = null;
        when(countryService.createCountry(countryDTO)).thenReturn(country);

        ResponseEntity<CountryDTO> responseEntity = countryController.createCountry(countryDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());

    }

    @Test
    void deleteWithOk() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(countryService.deleteCountry(countryDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = countryController.deleteCountry(countryDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getResult(), successModel.getResult());
    }

    @Test
    void deleteWithFail() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();

        when(countryService.deleteCountry(countryDTO)).thenReturn(false);

        ResponseEntity<SuccessModel> responseEntity = countryController.deleteCountry(countryDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }
}