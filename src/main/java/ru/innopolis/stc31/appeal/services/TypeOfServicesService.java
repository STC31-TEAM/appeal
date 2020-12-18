package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.TypeOfServiceDTO;

import java.util.List;

/**
 * interface for type of services services
 *
 * @author v.shulepov
 */
public interface TypeOfServicesService {
    /**
     * return list of all type of services
     * @return
     */
    List<TypeOfServiceDTO> getTypeOfServiceList();

    /**
     * create new type of service
     * @param typeOfServiceDTO type of service
     * @return result of operation
     */
    boolean createTypeOfService(TypeOfServiceDTO typeOfServiceDTO);

    /**
     * delete type of service from base
     * @param typeOfServiceDTO type of service needed to remove
     * @return result of operation
     */
    boolean deleteTypeOfService(TypeOfServiceDTO typeOfServiceDTO);
}
