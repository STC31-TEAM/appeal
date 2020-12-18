package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.UserDTO;

import java.util.List;

/**
 * interface for User services
 *
 * @author v.shulepov
 */
public interface UsersService {
    /**
     * return list of all users
     * @return list of users
     */
    List<UserDTO> getUserList();

    /**
     * create new user
     * @param userDTO user
     * @return result of operation
     */
    boolean createUser(UserDTO userDTO);

    /**
     * delete user from base
     * @param userDTO user needed to remove
     * @return result of operation
     */
    boolean deleteUser(UserDTO userDTO);
}
