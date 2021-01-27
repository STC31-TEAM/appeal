package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;

import java.util.List;

/**
 * interface for Country services
 *
 * @author v.shulepov
 */
public interface CountryService {
    /**
     * return list of all countries
     * @return list of countries
     */
    List<CountryDTO> getCountryList();

    /**
     * create new country
     * @param countryDTO country
     * @return Country
     */
    Country createCountry(CountryDTO countryDTO);

    /**
     * delete country from base
     * @param countryDTO country needed to remove
     * @return result of operation
     */
    boolean deleteCountry(CountryDTO countryDTO);
}
