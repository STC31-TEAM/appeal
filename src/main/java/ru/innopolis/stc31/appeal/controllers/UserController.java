package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage users
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * Get list of all users
     *
     * @return List of users
     */
    @GetMapping("/all")
    public List<UserDTO> all() {
        // TODO: get all users
        return null;
    }

    /**
     * Create new user
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody UserDTO dto) {
        // TODO: save user
        return false;
    }
}
