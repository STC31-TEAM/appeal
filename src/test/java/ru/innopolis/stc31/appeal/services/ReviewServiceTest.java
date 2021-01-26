package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.City;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.repository.CityRepository;
import ru.innopolis.stc31.appeal.repository.CountryRepository;
import ru.innopolis.stc31.appeal.repository.StreetRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles({"test"})
class ReviewServiceTest {

    @Spy
    private CompanyService companyService;

    @Spy
    private CountryService countryService;

    @Spy
    private CityService cityService;

    @Spy
    private StreetService streetService;

    @Spy
    private CountryRepository countryRepository;

    @Spy
    private CityRepository cityRepository;

    @Spy
    private StreetRepository streetRepository;

    @InjectMocks
    ReviewService reviewService;

    @Test
    void getAllCompanyTitle() {
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(1l).setTitle("SomeCompany");
        companyDTOList.add(companyDTO);
        when(companyService.getCompanyList()).thenReturn(companyDTOList);

        assertTrue(reviewService.getAllCompanyTitle().containsKey(companyDTO.getTitle()));
    }

    @Test
    void getAllCompany() {

        List<CompanyDTO> companyDTOList = new ArrayList<>();
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(1l).setTitle("SomeCompany");
        companyDTOList.add(companyDTO);
        when(companyService.getCompanyList()).thenReturn(companyDTOList);

        assertTrue(reviewService.getAllCompanyTitle().containsKey(companyDTO.getTitle()));
    }

    @Test
    void getFullAddressIsNotNull() {

        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        Country country = MockUtils.makeCountryEntity();
        City city = MockUtils.makeCityEntity();
        Street street = MockUtils.makeStreetEntity();
        companyDTO.setCountryId(country.getId()).setCityId(city.getId()).setStreetId(street.getId());
        when(countryRepository.findById(companyDTO.getCountryId())).thenReturn(Optional.ofNullable(country));
        when(cityRepository.findById(companyDTO.getCountryId())).thenReturn(Optional.ofNullable(city));
        when(streetRepository.findById(companyDTO.getCountryId())).thenReturn(Optional.ofNullable(street));

        assertTrue(reviewService.getFullAddress(companyDTO).contains(country.getCountryName()));
        assertTrue(reviewService.getFullAddress(companyDTO).contains(city.getCityName()));
        assertTrue(reviewService.getFullAddress(companyDTO).contains(street.getStreetName()));
    }

    @Test
    void getFullAddressIsNull() {
        assertNull(reviewService.getFullAddress(null));
    }

    @Test
    void getAllCountryName() {
        List<CountryDTO> countryDTOList = new ArrayList<>();
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        countryDTOList.add(countryDTO);
        when(countryService.getCountryList()).thenReturn(countryDTOList);

        assertTrue(reviewService.getAllCountryName().containsKey(countryDTO.getCountryName()));
    }

    @Test
    void getAllCityName() {
        List<CityDTO> cityDTOList = new ArrayList<>();
        CityDTO CityDTO = MockUtils.makeCityDTO();
        cityDTOList.add(CityDTO);
        when(cityService.getCityList()).thenReturn(cityDTOList);

        assertTrue(reviewService.getAllCityName().containsKey(CityDTO.getCityName()));
    }

    @Test
    void getAllStreetName() {
        List<StreetDTO> streetDTOList = new ArrayList<>();
        StreetDTO streetDTO = MockUtils.makeStreetDTO();
        streetDTOList.add(streetDTO);
        when(streetService.getStreetList()).thenReturn(streetDTOList);

        assertTrue(reviewService.getAllStreetName().containsKey(streetDTO.getStreetName()));
    }
}