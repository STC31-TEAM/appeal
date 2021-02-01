package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;

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
     * Return user
     *
     * @param name of user
     * @return user
     */
    UserDTO getUserByName(String name);

    /**
     * create new user
     *
     * @param userDTO user
     * @return result of operation, object User
     */
    User createUser(UserDTO userDTO) throws UsersErrors;

    /**
     * delete user from base
     * @param userDTO user needed to remove
     * @return result of operation
     */
    boolean deleteUser(UserDTO userDTO);
}
