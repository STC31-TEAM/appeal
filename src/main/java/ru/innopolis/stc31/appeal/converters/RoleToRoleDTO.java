package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;

@Component
public class RoleToRoleDTO implements Converter<Role, RoleDTO> {

    @Override
    public RoleDTO convert(Role source) {

        return new RoleDTO()
                .setId(source.getId())
                .setTitle(source.getTitle());
    }
}
