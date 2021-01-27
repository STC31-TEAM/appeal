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
@RequestMapping("${application.api.uriPrefix}/role/admin")
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
    public RoleDTO createRole(@RequestBody RoleDTO dto) {
        return roleService.createRole(dto);
    }

    /**
     * Update role
     *
     * @param dto Model
     * @return true if success created
     */
    @PutMapping("/update")
    @ApiOperation("Обновить роль")
    public RoleDTO updateRole(@RequestBody RoleDTO dto) {
        return roleService.updateRole(dto);
    }

    /**
     * Delete role
     *
     * @param dto Model
     * @return true if success created
     */
    @DeleteMapping("/delete")
    @ApiOperation("Удалить роль")
    public RoleDTO deleteRole(@RequestBody RoleDTO dto) {
        return roleService.deleteRole(dto);
    }
}
