package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.services.RoleService;

import java.util.List;

/**
 * Controller for manage roles
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/role")
public class RoleController {

    /** Role service instance */
    private final RoleService roleService;

    /**
     * Get list of all roles
     *
     * @return List of roles
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех ролей")
    public List<RoleDTO> getAllRoles() {
        return roleService.getRoleList();
    }

    /**
     * Create new role
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить роль")
    public boolean createRole(@RequestBody RoleDTO dto) {
        return roleService.createRole(dto);
    }
}
