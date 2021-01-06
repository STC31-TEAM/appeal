package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.UsersService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing UserController
 *
 * @author Sergey Fomin
 */
@SpringJUnitConfig
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UsersService usersService;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> userController.all());
        assertDoesNotThrow(() -> userController.create(new UserDTO()));
    }

    @Test
    void checkGetAllWithOk() {
        List<UserDTO> users = MockUtils.makeListUserDTO(5);
        when(usersService.getUserList()).thenReturn(users);

        assertEquals(users.size(), userController.all().size());
        assertEquals(users.get(1).getLogin(), userController.all().get(1).getLogin());
        assertEquals(users.get(1).getPhone(), userController.all().get(1).getPhone());
    }

    @Test
    void checkCreateWithOk() {
        UserDTO user = MockUtils.makeUserDTO();

        when(usersService.createUser(user)).thenReturn(true);

        assertTrue(userController.create(user));
    }
}