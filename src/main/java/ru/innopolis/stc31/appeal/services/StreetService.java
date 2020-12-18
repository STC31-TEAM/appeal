package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.StreetDTO;

import java.util.List;

/**
 * interface for Street services
 *
 * @author v.shulepov
 */
public interface StreetService {
    /**
     * return list of all streets
     * @return list of streets
     */
    List<StreetDTO> getStreetList();

    /**
     * create new street
     * @param streetDTO street
     * @return result of operation
     */
    boolean createStreet(StreetDTO streetDTO);

    /**
     * delete street from base
     * @param streetDTO street needed to remove
     * @return result of operation
     */
    boolean deleteStreet(StreetDTO streetDTO);
}
