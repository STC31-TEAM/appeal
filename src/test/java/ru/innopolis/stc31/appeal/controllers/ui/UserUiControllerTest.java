package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;
import ru.innopolis.stc31.appeal.controllers.UserController;
import ru.innopolis.stc31.appeal.converters.UserDTOToUser;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.services.UsersService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class UserUiControllerTest {

    @Spy
    private UserToUserDTO userToUserDTO;

    @Spy
    private UserDTOToUser userDTOToUser;

    @Spy
    private UsersService usersService;

    @Mock
    private Model model;

    @InjectMocks
    private UserUiController userUiController;

    @Test
    void checkCreateWithOk() throws UsersErrors {

        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = userDTOToUser.convert(userDTO);
        user.setId(1);
        when(usersService.createUser(userDTO)).thenReturn(user);

        String responseEntity = userUiController.createUser(userDTO, model);

        assertNotNull(responseEntity);
    }

    @Test
    void checkCreateWithFail() throws UsersErrors {

        UserDTO userDTO = MockUtils.makeUserDTO();
        when(usersService.createUser(userDTO)).thenReturn(null);

        String view = userUiController.createUser(userDTO, model);

        assertNotNull(view);
    }
}