package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ReviewService {

    private final CompanyService companyService;
    private final CountryService countryService;
    private final CityService cityService;
    private final StreetService streetService;

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;

    /**
     * Метод возвращает наименования всех
     * компаний в репозитории и их id
     *
     * @return объект Map
     */
    public Map<String,Long> getAllCompanyTitle(){
        List<CompanyDTO> companyDTOList= companyService.getCompanyList();
        Map<String,Long> listCompany = new HashMap<>();
        listCompany.put(null,0l);
        for (CompanyDTO companyDTO: companyDTOList){
            listCompany.put(companyDTO.getTitle(), companyDTO.getId() );
        }
        return listCompany;
    }

    /**
     * Метод возвращает наименование всех
     * компаний в репозитории и соответствующий объект
     * CompanyDTO
     *
     * @return объект Map
     */
    public Map<String,CompanyDTO> getAllCompany(){
        List<CompanyDTO> companyDTOList= companyService.getCompanyList();
        Map<String,CompanyDTO> listCompany = new HashMap<>();
        for (CompanyDTO companyDTO: companyDTOList){
            companyDTO.setFullAddress(getFullAddress(companyDTO));
            listCompany.put(companyDTO.getTitle(), companyDTO );
        }
        return listCompany;
    }

    /**
     * Метод возвращает полный адрес компании
     * на основании id свойств содержащихся в объекте
     * companyDTO
     *
     * @param companyDTO - объект DTO для компании
     * @return String - полный адрес
     */
    public String getFullAddress(CompanyDTO companyDTO){

        if(companyDTO == null){
            return null;
        }

        Optional<String> optionalCountry = countryRepository.findById(companyDTO.getCountryId())
                .map(Country::getCountryName);

        Optional<String> optionalCity = cityRepository.findById(companyDTO.getCountryId())
                .map(City::getCityName);

        Optional<String> optionalStreet = streetRepository.findById(companyDTO.getCountryId())
                .map(Street::getStreetName);

        return buildFullAddress(optionalCountry, optionalCity, optionalStreet);
    }

    /**
     * Метод собирает последовательно
     * из аргументов строку адреса
     *
     * @param country - страна
     * @param city - город
     * @param street - улица
     * @return String - собранный адрес
     */
    private String buildFullAddress(Optional<String> country, Optional<String> city, Optional<String> street){
        StringBuilder sb = new StringBuilder();

        country.ifPresent(sb::append);
        city.ifPresent(s -> sb.append(", ").append(s));
        street.ifPresent(s -> sb.append(", ").append(s));

        return sb.toString();
    }

    /**
     * Метод возвращает наименование всех
     * стран в репозитории и их id
     *
     * @return объект Map
     */
    public Map<String,Long> getAllCountryName(){
        List<CountryDTO> countryDTOList= countryService.getCountryList();
        Map<String,Long> listCountry = new HashMap<>();
        listCountry.put(null,0l);
        for (CountryDTO countryDTO: countryDTOList){
            listCountry.put(countryDTO.getCountryName(), countryDTO.getId() );
        }
        return listCountry;
    }

    /**
     * Метод возвращает наименование всех
     * городов в репозитории и их id
     *
     * @return объект Map
     */
    public Map<String,Long> getAllCityName(){
        List<CityDTO> cityDTOList= cityService.getCityList();
        Map<String,Long> listCity = new HashMap<>();
        listCity.put(null,0l);
        for (CityDTO cityDTO: cityDTOList){
            listCity.put(cityDTO.getCityName(), cityDTO.getId() );
        }
        return listCity;
    }

    /**
     * Метод возвращает наименование всех
     * улиц в репозитории и их id
     *
     * @return объект Map
     */
    public Map<String,Long> getAllStreetName(){
        List<StreetDTO> streetDTOList= streetService.getStreetList();
        Map<String,Long> listStreet = new HashMap<>();
        listStreet.put(null,0l);
        for (StreetDTO streetDTO: streetDTOList){
            listStreet.put(streetDTO.getStreetName(), streetDTO.getId() );
        }
        return listStreet;
    }

}
