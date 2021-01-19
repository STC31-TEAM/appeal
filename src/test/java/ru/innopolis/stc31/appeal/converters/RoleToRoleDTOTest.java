package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class RoleToRoleDTOTest {

    @InjectMocks
    private RoleToRoleDTO roleToRoleDTO;

    @Test
    public void convert() {
        Role role = MockUtils.makeRoleEntity();
        assertEquals(Objects.requireNonNull(roleToRoleDTO.convert(role)).getId(), role.getId());
    }
}