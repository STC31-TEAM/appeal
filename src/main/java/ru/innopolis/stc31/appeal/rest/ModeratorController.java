package ru.innopolis.stc31.appeal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.ModelMock;
import ru.innopolis.stc31.appeal.repository.TicketRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

/**
 * Controller to moderate
 */
@RestController
public class ModeratorController {
    /**
     * Repository of tickets
     */
    protected TicketRepository ticketRepository;

    /**
     * Repository of users
     */
    protected UserRepository userRepository;

    /**
     * Constructor
     *
     * @param ticketRepository Injected bean
     * @param userRepository Injected bean
     */
    public ModeratorController(@Autowired TicketRepository ticketRepository,
                               @Autowired UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    /**
     * Edit ticket (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/edit-ticket")
    public String editTicket() {
        // TODO: render form
        return null;
    }

    /**
     * Edit ticket (Save)
     *
     * @param model Ticket model
     * @return true if success edited
     */
    @PostMapping("/edit-ticket")
    public boolean editTicket(@RequestBody ModelMock model) {
        // TODO: save ticket
        return false;
    }

    /**
     * Close ticket
     *
     * @param ticketId Ticket id for close
     * @return true if success closed
     */
    @PostMapping("/close-ticket")
    public boolean closeTicket(@Param("id") int ticketId) {
        // TODO: close ticket
        return false;
    }

    /**
     * Edit company account (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/edit-company-account")
    public String editCompanyAccount() {
        // TODO: render edit form
        return null;
    }

    /**
     * Edit company account (Save)
     *
     * @param companyAccount Model
     * @return true if success edited
     */
    @PostMapping("/edit-company-account")
    public boolean editCompanyAccount(@RequestBody ModelMock companyAccount) {
        // TODO: save company account
        return false;
    }

    /**
     * Edit user account (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/edit-user-account")
    public String editUserAccount() {
        // TODO: render edit form
        return null;
    }

    /**
     * Edit user account (Save)
     *
     * @param userAccount Model
     * @return true if success edited
     */
    @PostMapping("/edit-user-account")
    public boolean editUserAccount(@RequestBody ModelMock userAccount) {
        // TODO: save user account
        return false;
    }

    /**
     * Verify company
     *
     * @param companyId Company identifier
     * @return true if success verify
     */
    @PostMapping("/verify-company")
    public boolean verifyCompany(@Param("id") int companyId) {
        // TODO: verify company
        return false;
    }

    /**
     * Verify ticket
     *
     * @param ticketId Ticket identifier
     * @return true if success verify
     */
    @PostMapping("/verify-ticket")
    public boolean verifyTicket(@Param("id") int ticketId) {
        // TODO: verify ticket
        return false;
    }

    /**
     * Verify user
     *
     * @param userId User identifier
     * @return true if success verify
     */
    @PostMapping("/verify-user")
    public boolean verifyUser(@Param("id") int userId) {
        // TODO: verify user
        return false;
    }
}
