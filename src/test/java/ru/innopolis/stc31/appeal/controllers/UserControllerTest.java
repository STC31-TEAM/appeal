package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.innopolis.stc31.appeal.MockUtils;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.UsersService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Testing UserController
 *
 * @author Sergey Fomin
 */
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UsersService usersService;

    /**
     * Execute before each test
     */
    @BeforeEach
    void setUp() {
        openMocks(this);
    }

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> userController.all());
        assertDoesNotThrow(() -> userController.create(new UserDTO()));
    }

    @Test
    void checkGetAllWithOk() {
        List<UserDTO> users = MockUtils.makeListUserDTO();
        when(usersService.getUserList()).thenReturn(users);

        assertEquals(2, userController.all().size());
        assertEquals("user02", userController.all().get(1).getLogin());
        assertEquals(89129984444L, userController.all().get(1).getPhone());
    }

    @Test
    void checkCreateWithOk() {
        UserDTO user = MockUtils.makeUserDTO();

        when(usersService.createUser(user)).thenReturn(true);

        assertTrue(userController.create(user));
    }
}