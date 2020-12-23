package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.UsersService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
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
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "User 01", "user01@asd.ru", 89129987092L, LocalDate.now(), (short) 1));
        users.add(new UserDTO(2, "user02", "User 02", "user02@asd.ru", 89129987092L, LocalDate.now(), (short) 1));

        when(usersService.getUserList()).thenReturn(users);

        assertEquals(2, userController.all().size());
        assertEquals("user02", userController.all().get(1).getLogin());
    }

    @Test
    void checkCreateWithOk() {
        UserDTO user = new UserDTO(1, "user01", "User 01", "user01@asd.ru", 89129987092L, LocalDate.now(), (short) 1);

        when(usersService.createUser(user)).thenReturn(true);

        assertTrue(userController.create(user));
    }
}