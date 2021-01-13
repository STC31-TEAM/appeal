package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.services.TicketService;

import java.util.List;

/**
 * Controller for manage tickets
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/ticket")
public class TicketController {

    /** Ticket service instance */
    private final TicketService ticketService;

    /**
     * Get list of all tickets
     *
     * @return List of tickets
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех заявок")
    public List<TicketDTO> getAllTickets() {
        return ticketService.getTicketList();
    }

    /**
     * Create new ticket
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить заявку")
    public boolean createTicket(@RequestBody TicketDTO dto) {
        return ticketService.createTicket(dto);
    }
}
