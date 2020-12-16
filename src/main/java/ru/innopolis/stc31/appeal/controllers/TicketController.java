package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage tickets
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    /**
     * Get list of all tickets
     *
     * @return List of tickets
     */
    @GetMapping("/all")
    public List<TicketDTO> all() {
        // TODO: get all tickets
        return null;
    }

    /**
     * Create new ticket
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody TicketDTO dto) {
        // TODO: save ticket
        return false;
    }
}
