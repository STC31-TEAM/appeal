package ru.innopolis.stc31.appeal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.ModelMock;
import ru.innopolis.stc31.appeal.repository.TicketRepository;

import java.util.List;

/**
 * Individual controller
 */
@RestController
public class PersonController {
    /**
     * Repository of tickets
     */
    protected TicketRepository ticketRepository;

    /**
     * Constructor
     *
     * @param ticketRepository Injected bean
     */
    public PersonController(@Autowired TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * @return List of likes tickets
     */
    @GetMapping("/likes-tickets")
    public List<ModelMock> likesTickets() {
        // TODO: get your likes tickets
        return null;
    }

    /**
     * Vote a ticket
     *
     * @param ticketId Ticket identifier
     * @param voteForOrAgainst Vote for or against
     */
    @GetMapping("/vote-ticket")
    public void voteTicket(@Param("id") int ticketId, @Param("yes") boolean voteForOrAgainst) {
        // TODO: vote a ticket
    }

    /**
     * Create a ticket (Form)
     *
     * @return Rendered form
     */
    @GetMapping("/create-ticket")
    public String createTicket() {
        // TODO: create a ticket
        return null;
    }

    /**
     * Create a ticket (Save)
     *
     * @return Rendered form
     */
    @PostMapping("/create-ticket")
    public boolean createTicket(@RequestBody ModelMock ticket) {
        // TODO: save a ticket
        return false;
    }

    /**
     * Show created tickets
     *
     * @return List of your created tickets
     */
    @GetMapping("/show-created")
    public List<ModelMock> showCreated() {
        // TODO: get your created tickets
        return null;
    }
}
