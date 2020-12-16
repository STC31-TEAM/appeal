package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.RoleDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage roles
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    /**
     * Get list of all roles
     *
     * @return List of roles
     */
    @GetMapping("/all")
    public List<RoleDTO> all() {
        // TODO: get all roles
        return null;
    }

    /**
     * Create new role
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody RoleDTO dto) {
        // TODO: save role
        return false;
    }
}
