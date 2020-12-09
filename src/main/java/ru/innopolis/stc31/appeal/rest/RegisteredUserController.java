package ru.innopolis.stc31.appeal.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.ModelMock;

/**
 * Controller to control profile
 */
@RestController
public class RegisteredUserController {
    /**
     * Edit user account (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/edit-account")
    public String editAccount() {
        // TODO: render form
        return null;
    }

    /**
     * Edit user account (Save)
     *
     * @return true if success edited
     */
    @PostMapping("/edit-account")
    public boolean editAccount(@RequestBody ModelMock userAccount) {
        // TODO: save user account
        return false;
    }

    /**
     * Delete user account
     *
     * @return true if success deleted
     */
    @PostMapping("/delete-account")
    public boolean deleteAccount(@RequestBody ModelMock userAccount) {
        // TODO: delete user account
        return false;
    }

    /**
     * Authorization
     *
     * @return true if success authorization
     */
    @PostMapping("/auth")
    public boolean auth(@RequestBody ModelMock userAccount) {
        // TODO: user authorization
        return false;
    }
}
