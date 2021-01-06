package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
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

        assertEquals(countryDTOList.size(), countryController.all().size());
        assertEquals(countryDTOList.get(1).getCountryName(), countryController.all().get(1).getCountryName());
    }

    @Test
    void create() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        Country country = countryDTOToCountry.convert(countryDTO);
        country.setId(1);
        when(countryService.createCountry(countryDTO)).thenReturn(country);

        ResponseEntity<CountryDTO> responseEntity = countryController.create(countryDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getCountryName(), countryDTO.getCountryName());

    }

    @Test
    void delete() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(countryService.deleteCountry(countryDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = countryController.delete(countryDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getResult(), successModel.getResult());
    }
}