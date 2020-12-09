package ru.innopolis.stc31.appeal.rest;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.ModelMock;

@RestController
@RequestMapping("/company")
public class CompanyController {
    /**
     * Edit company account (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/edit-account")
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
    @PostMapping("/edit-account")
    public boolean editCompanyAccount(@RequestBody ModelMock companyAccount) {
        // TODO: save company account
        return false;
    }

    /**
     * Execute an appeal
     *
     * @param ticketId Ticket identifier
     */
    @PostMapping("/comply-ticket")
    public void complyTicket(@Param("id") int ticketId) {
        // TODO: comply ticket
    }
}
