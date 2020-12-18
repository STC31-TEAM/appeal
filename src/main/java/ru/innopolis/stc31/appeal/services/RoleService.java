package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.RoleDTO;

import java.util.List;

/**
 * interface for Role services
 *
 * @author v.shulepov
 */
public interface RoleService {
    /**
     * return list of all roles
     * @return list of roles
     */
    List<RoleDTO> getRoleList();

    /**
     * create new role
     * @param roleDTO role
     * @return result of operation
     */
    boolean createRole(RoleDTO roleDTO);

    /**
     * delete ticket from base
     * @param roleDTO ticket needed to remove
     * @return result of operation
     */
    boolean deleteRole(RoleDTO roleDTO);
}
