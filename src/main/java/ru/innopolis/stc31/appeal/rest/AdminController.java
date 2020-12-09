package ru.innopolis.stc31.appeal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.User;
import ru.innopolis.stc31.appeal.repository.UserRepository;

/**
 * Controller for administration
 */
@RestController
public class AdminController {
    /**
     * Repository of users
     */
    protected UserRepository userRepository;

    /**
     * @param userRepository Injected bean
     */
    public AdminController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Delete user account
     *
     * @param userId User id need for remove a user account
     * @return true if success removed
     */
    @PostMapping("/delete-user")
    public boolean deleteUser(@Param("id") int userId) {
        return true;
    }

    /**
     * Make a user a moderator
     *
     * @param user User candidate to moderator
     * @return true if success set moderator
     */
    @PostMapping("/set-moderator")
    public boolean setModerator(@RequestBody User user) {
        // change user role to moderator
        return true;
    }
}
