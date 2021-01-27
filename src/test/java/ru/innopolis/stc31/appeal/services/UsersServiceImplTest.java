package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.UserDTOToUser;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing UserServiceImpl
 */
@SpringJUnitConfig
@ActiveProfiles({"test"})
class UsersServiceImplTest {


    @Spy
    UserRepository userRepository;

    @Spy
    UserDTOToUser userDTOToUser;

    @Spy
    UserToUserDTO userToUserDTO;

    @Spy
    RoleRepository roleRepository;

    @Spy
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersServiceImpl usersService;

    @Test
    void createUserOk() throws UsersErrors {
        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = userDTOToUser.convert(userDTO);
        user.setCountryId(1);
        user.setStreetId(1);
        user.setCityId(1);
        user.setStatus((short) 0);
        Role role = new Role();
        role.setId(1);
        role.setTitle(Roles.USER.toString());
        when(userDTOToUser.convert(userDTO)).thenReturn(user);
        when(roleRepository.findByTitle(Roles.USER.toString())).thenReturn(role);
        when(userRepository.save(user)).thenReturn(user);
        assertEquals(user.getLogin(), usersService.createUser(userDTO).getLogin());
    }

    @Test
    void createUserFail(){
        Role role = new Role();
        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = userDTOToUser.convert(userDTO);
        when(userDTOToUser.convert(userDTO)).thenReturn(user);
        when(roleRepository.findByTitle(Roles.USER.toString())).thenReturn(role);

        assertThrows(UsersErrors.class, () -> usersService.createUser(userDTO));
    }

        @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> usersService.deleteUser(MockUtils.makeUserDTO()));
        assertDoesNotThrow(() -> usersService.getUserByName(MockUtils.makeUserDTO().getName()));
        assertDoesNotThrow(() -> usersService.getUserList());
    }

    @Test
    void getUserList() {
        List<User> userList = new ArrayList<>();
        MockUtils.makeListUserDTO(4).stream().forEach(userDTO -> {
            userList.add(
                    userDTOToUser.convert(userDTO)
            );
        } );
        when(userRepository.findAll()).thenReturn(userList);

        assertEquals(userList.size(), usersService.getUserList().size());
        assertEquals(userList.get(1).getLogin(), usersService.getUserList().get(1).getLogin());
    }
}
