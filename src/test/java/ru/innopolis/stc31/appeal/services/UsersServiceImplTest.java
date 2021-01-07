package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing UserServiceImpl
 */
@SpringJUnitConfig
class UsersServiceImplTest {

    @InjectMocks
    private UsersServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createUser(MockUtils.makeUserDTO()));
        assertDoesNotThrow(() -> service.deleteUser(MockUtils.makeUserDTO()));
        assertDoesNotThrow(() -> service.getUserByName(MockUtils.makeUserDTO().getUsername()));
        assertDoesNotThrow(() -> service.getUserList());
    }
}
