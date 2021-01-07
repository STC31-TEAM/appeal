package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing RoleServiceImpl
 */
@SpringJUnitConfig
class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createRole(MockUtils.makeRoleDTO()));
        assertDoesNotThrow(() -> service.deleteRole(MockUtils.makeRoleDTO()));
        assertDoesNotThrow(() -> service.getRoleList());
    }
}
