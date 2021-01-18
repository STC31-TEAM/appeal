package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

/**
 * Testing RoleServiceImpl
 */
@SpringJUnitConfig
class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl service;

    @Spy
    private ConversionService conversionService;

    @Spy
    private RoleRepository repository;

    @Test
    void checkOnOk() {
        RoleDTO roleDTO = MockUtils.makeRoleDTO();
        Role role = MockUtils.makeRoleEntity();
        when(conversionService.convert(roleDTO, Role.class)).thenReturn(role);

        assertDoesNotThrow(() -> service.createRole(roleDTO));
        assertDoesNotThrow(() -> service.deleteRole(roleDTO));
        assertDoesNotThrow(() -> service.getRoleList());
    }
}
