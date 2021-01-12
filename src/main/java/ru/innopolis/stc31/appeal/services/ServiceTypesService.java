package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;

import java.util.List;

/**
 * interface for type of services services
 *
 * @author v.shulepov
 */
public interface ServiceTypesService {
    /**
     * return list of all type of services
     * @return
     */
    List<ServiceTypeDTO> getTypeOfServiceList();

    /**
     * create new type of service
     * @param serviceTypeDTO type of service
     * @return result of operation
     */
    boolean createTypeOfService(ServiceTypeDTO serviceTypeDTO);

    /**
     * delete type of service from base
     * @param serviceTypeDTO type of service needed to remove
     * @return result of operation
     */
    boolean deleteTypeOfService(ServiceTypeDTO serviceTypeDTO);
}
