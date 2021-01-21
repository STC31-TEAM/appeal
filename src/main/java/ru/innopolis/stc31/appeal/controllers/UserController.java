package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
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

    /** Service instance */
    private final UsersService usersService;
    private final UserToUserDTO userToUserDTO;

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
     * @return ResponseEntity<UserDTO>
     */
    @PostMapping("/create")
    @ApiOperation("Добавить пользователя")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) throws UsersErrors {

        log.debug("create user method was called with {} ", dto);

        var user = usersService.createUser(dto);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("create user method return result {} ", user);

        return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.OK);
    }
}
