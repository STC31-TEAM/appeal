package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    RoleRepository roleRepository;

    @Spy
    PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersServiceImpl service;

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
        assertEquals(user.getLogin(), service.createUser(userDTO).getLogin());
    }

    @Test
    void createUserFail() throws UsersErrors {
        Role role = new Role();
        UserDTO userDTO = MockUtils.makeUserDTO();
        User user = userDTOToUser.convert(userDTO);
        when(userDTOToUser.convert(userDTO)).thenReturn(user);
        when(roleRepository.findByTitle(Roles.USER.toString())).thenReturn(role);

        assertThrows(UsersErrors.class, () -> service.createUser(userDTO));
    }

        @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.deleteUser(MockUtils.makeUserDTO()));
        assertDoesNotThrow(() -> service.getUserByName(MockUtils.makeUserDTO().getName()));
        assertDoesNotThrow(() -> service.getUserList());
    }
}
