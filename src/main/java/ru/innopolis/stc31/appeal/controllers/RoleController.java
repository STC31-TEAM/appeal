package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;
import ru.innopolis.stc31.appeal.services.RoleService;

import java.util.List;

/**
 * Controller for manage roles
 *
 * @author Sergey Fomin
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/role")
public class RoleController {
    /**
     * Service instance
     */
    private final RoleService roleService;

    /**
     * Get list of all roles
     *
     * @return List of roles
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех ролей")
    public List<RoleDTO> all() {
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
    public boolean create(@RequestBody RoleDTO dto) {
        return roleService.createRole(dto);
    }
}
