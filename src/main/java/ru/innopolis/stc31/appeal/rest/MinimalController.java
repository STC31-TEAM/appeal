package ru.innopolis.stc31.appeal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.innopolis.stc31.appeal.model.ModelMock;
import ru.innopolis.stc31.appeal.repository.TicketRepository;

import java.util.List;

/**
 * Rest controller for unregistered users
 */
@RestController
public class MinimalController {
    /**
     * Repository of tickets
     */
    protected TicketRepository ticketRepository;

    /**
     * Constructor
     *
     * @param ticketRepository Injected bean
     */
    public MinimalController(@Autowired TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * List of a tickets
     *
     * @return List of all a tickets
     */
    @GetMapping("/tickets")
    public List<ModelMock> allTickets(){
        return ticketRepository.findAll();
    }

    /**
     * Show the register form
     *
     * @return Rendered form
     */
    @GetMapping("/register")
    public String register() {
        return "Render register form";
    }

    /**
     * Register user and save register data
     *
     * @param model User/Company registration data
     */
    @PostMapping("/register")
    public void register(ModelMock model) {
        // TODO: save registration data
    }
}
