package ru.innopolis.stc31.appeal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final ConversionService conversionService;

    public RoleServiceImpl(@Autowired RoleRepository repository,
                           @Qualifier("mvcConversionService") ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public List<RoleDTO> getRoleList() {
        List<RoleDTO> result = new ArrayList<>();
        for (Role role : repository.findAll()) {
            result.add(conversionService.convert(role, RoleDTO.class));
        }
        return result;
    }

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = conversionService.convert(roleDTO, Role.class);
        assert role != null;
        repository.save(role);
        return roleDTO;
    }

    @Override
    public RoleDTO updateRole(RoleDTO roleDTO) {
        Role role = conversionService.convert(roleDTO, Role.class);
        assert role != null;
        role.setId(roleDTO.getId());
        repository.save(role);
        return roleDTO;
    }

    @Override
    public RoleDTO deleteRole(RoleDTO roleDTO) {
        repository.deleteById(roleDTO.getId());
        return roleDTO;
    }
}
