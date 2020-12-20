package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.CityDTO;

import java.util.List;

/**
 * interface for City services
 *
 * @author v.shulepov
 */
public interface CityService {
    /**
     * return list of all cities
     * @return list of cities
     */
    List<CityDTO> getCityList();

    /**
     * create new city
     * @param cityDTO city
     * @return result of operation
     */
    boolean createCity(CityDTO cityDTO);

    /**
     * delete city from base
     * @param cityDTO city needed to remove
     * @return result of operation
     */
    boolean deleteCity(CityDTO cityDTO);
}
