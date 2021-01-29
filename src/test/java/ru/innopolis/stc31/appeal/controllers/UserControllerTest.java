package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.UserDTOToUser;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.services.UsersService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testing UserController
 *
 * @author Sergey Fomin
 */
@SpringJUnitConfig
class UserControllerTest {

    @Spy
    private UserToUserDTO userToUserDTO;

    @Spy
    private UserDTOToUser userDTOToUser;

    @Spy
    private UsersService usersService;

    @InjectMocks
    private UserController userController;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> userController.getAllUsers());
        assertDoesNotThrow(() -> userController.createUser(MockUtils.makeUserDTO()));
    }

    @Test
    void checkGetAllWithOk() {
        List<UserDTO> users = MockUtils.makeListUserDTO(5);
        when(usersService.getUserList()).thenReturn(users);

        assertEquals(users.size(), userController.getAllUsers().size());
        assertEquals(users.get(1).getLogin(), userController.getAllUsers().get(1).getLogin());
        assertEquals(users.get(1).getPhone(), userController.getAllUsers().get(1).getPhone());
    }

    @Test
    void checkCreateWithOk() throws UsersErrors {

        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = userDTOToUser.convert(userDTO);
        user.setId(1);
        when(usersService.createUser(userDTO)).thenReturn(user);

        ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getLogin(), userDTO.getLogin());

    }

    @Test
    void checkCreateWithFail() throws UsersErrors {

        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = null;
        when(usersService.createUser(userDTO)).thenReturn(user);

        ResponseEntity<UserDTO> responseEntity = userController.createUser(userDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());

    }
}