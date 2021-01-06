package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.converters.CountryDTOToCountry;
import ru.innopolis.stc31.appeal.converters.CountryToCountryDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.repository.CountryRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles({"test"})
class CountryServiceImplTest {

    @Mock
    private CountryRepository countryRepository;

    @Spy
    private CountryDTOToCountry countryDTOToCountry;

    @Spy
    private CountryToCountryDTO countryToCountryDTO;

    @InjectMocks
    private CountryServiceImpl countryServiceImpl;


    @Test
    void getCountryList() {
        List<Country> countryList = new ArrayList<>();
        MockUtils.makeListCountryDTO(4).stream().forEach(countryDTO -> {
            countryList.add(
                    countryDTOToCountry.convert(countryDTO)
            );
        } );
        when(countryRepository.findAll()).thenReturn(countryList);

        assertEquals(countryList.size(), countryServiceImpl.getCountryList().size());
        assertEquals(countryList.get(1).getCountryName(), countryServiceImpl.getCountryList().get(1).getCountryName());
    }

    @Test
    void createCountry() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        Country country = countryDTOToCountry.convert(countryDTO);
        country.setId(1);
        when(countryRepository.save(countryDTOToCountry.convert(countryDTO))).thenReturn(country);

        assertEquals(countryServiceImpl.createCountry(countryDTO).getId(), country.getId());
    }

    @Test
    void deleteCountry() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        assertEquals(countryServiceImpl.deleteCountry(countryDTO), true);
        verify(countryRepository).deleteById(any());
    }
}