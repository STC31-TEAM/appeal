package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.UsersService;

import java.util.List;

/**
 * Controller for manage users
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/user")
public class UserController {
    /**
     * Service instance
     */
    private final UsersService usersService;

    /**
     * Get list of all users
     *
     * @return List of users
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех пользователей")
    public List<UserDTO> getAllUsers() {
        return usersService.getUserList();
    }

    /**
     * Create new user
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить пользователя")
    public boolean create(@RequestBody UserDTO dto) {
        return usersService.createUser(dto);
    }
}
