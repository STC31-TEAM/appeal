package ru.innopolis.stc31.appeal.controllers.ui;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.UsersService;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/ui")
public class UserUiController {

    /** Service instance */
    private final UsersService usersService;
    private final UserToUserDTO userToUserDTO;

    /**
     * Create new user
     *
     * @param userDTO Model
     * @return ResponseEntity<UserDTO>
     */
    @PostMapping("/createUser")
    @ApiOperation("Добавить пользователя")
    public String createUser(UserDTO userDTO, Model model) {

        log.debug("create user method was called with {} ", userDTO);

        try {
            var user = usersService.createUser(userDTO);

            log.debug("create user method return result {} ", user);

            if (user == null) {
                ErrorMessage errorMessage = new ErrorMessage(-4,
                        "Не удалось создать учетную запись, исходные данные: " + userDTO);
                throw new UsersErrors(errorMessage);
            }
            log.debug("create user method return result {} ", user);
        } catch (UsersErrors usersErrors) {
            log.error(usersErrors.getErrorMessage().getErrorMessage());
            return "create-fail";
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return "create-fail";
        }
        return "create-success";
    }
}
