package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Override
    public List<RoleDTO> getRoleList() {
        return null;
    }

    @Override
    public boolean createRole(RoleDTO roleDTO) {
        return false;
    }

    @Override
    public boolean deleteRole(RoleDTO roleDTO) {
        return false;
    }
}
