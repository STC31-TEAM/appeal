package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("${application.api.uriPrefix}")
public class UserController {

    /** Service instance */
    private final UsersService usersService;
    private final UserToUserDTO userToUserDTO;

    /**
     * Get list of all users
     *
     * @return List of users
     */
    @GetMapping("/admin/all")
    @ApiOperation("Получить список всех пользователей")
    public List<UserDTO> getAllUsers() {
        return usersService.getUserList();
    }

    /**
     * Create new user
     *
     * @param userDTO Model
     * @return ResponseEntity<UserDTO>
     */
    @PostMapping("/createUser")
    @ApiOperation("Добавить пользователя")
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) throws UsersErrors {

        log.debug("create user method was called with {} ", userDTO);

        var user = usersService.createUser(userDTO);

        log.debug("create user method return result {} ", user);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userToUserDTO.convert(user), HttpStatus.OK);
    }
}
