package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;

@Component
public class RoleDTOToRole implements Converter<RoleDTO, Role> {

    /**
     * Do not specify id because when creating a record sql will create it automatically, otherwise it will try to find a relationship and possibly errors
     * If you need to specify id for the update query, then specify it manually
     *
     * @param source RoleDTO instance
     * @return Role instance
     */
    @Override
    public Role convert(RoleDTO source) {
        return new Role()
                .setTitle(source.getTitle());
    }
}
