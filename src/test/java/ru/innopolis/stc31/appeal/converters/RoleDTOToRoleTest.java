package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class RoleDTOToRoleTest {

    @InjectMocks
    private RoleDTOToRole roleDTOToRole;

    @Test
    void convert() {
        RoleDTO roleDTO = MockUtils.makeRoleDTO();
        assertEquals(Objects.requireNonNull(roleDTOToRole.convert(roleDTO)).getId(), roleDTO.getId());
    }
}