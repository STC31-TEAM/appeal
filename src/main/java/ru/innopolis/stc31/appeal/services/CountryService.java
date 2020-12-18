package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.CountryDTO;

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
    List<CountryDTO> getCountyList();

    /**
     * create new country
     * @param countryDTO country
     * @return result of operation
     */
    boolean createCounty(CountryDTO countryDTO);

    /**
     * delete country from base
     * @param countryDTO country needed to remove
     * @return result of operation
     */
    boolean deleteCounty(CountryDTO countryDTO);
}
