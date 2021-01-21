package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.services.RoleService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testing RoleController
 */
@SpringJUnitConfig
class RoleControllerTest {

    @InjectMocks
    private RoleController controller;

    @Mock
    private RoleService service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllRoles());
        assertDoesNotThrow(() -> controller.createRole(MockUtils.makeRoleDTO()));
        assertDoesNotThrow(() -> controller.updateRole(MockUtils.makeRoleDTO()));
        assertDoesNotThrow(() -> controller.deleteRole(MockUtils.makeRoleDTO()));
    }

    @Test
    void getAllRolesWithOk() {
        List<RoleDTO> roles = MockUtils.makeListRoleDTO(5);
        when(service.getRoleList()).thenReturn(roles);

        assertEquals(roles.size(), controller.getAllRoles().size());
    }

    @Test
    void createRoleWithOk() {
        RoleDTO role = MockUtils.makeRoleDTO();

        when(service.createRole(role)).thenReturn(role);

        assertEquals(role.getId(), controller.createRole(role).getId());
    }
}
