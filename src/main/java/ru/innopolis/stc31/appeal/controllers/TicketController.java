package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.TicketToTicketDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.services.TicketService;

import java.util.List;

/**
 * Controller for manage tickets
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/ticket")
public class TicketController {

    /** Ticket service instance */
    private final TicketService ticketService;
    private final TicketToTicketDTO ticketToTicketDTO;

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
    @PostMapping("/user/create")
    @ApiOperation("Добавить заявку")
    public ResponseEntity <TicketDTO> createTicket(@RequestBody TicketDTO dto) {
        log.debug("create ticket method was called with {} ", dto);
        var ticket = ticketService.createTicket(dto);

        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("create ticket method return result {} ", ticket);
        return new ResponseEntity<>(ticketToTicketDTO.convert(ticket), HttpStatus.OK);
    }

    @PostMapping("/getClosedTickets")
    @ApiOperation("Найти закрытые заявки")
    public List<TicketDTO> getClosedTickets() {

        log.debug("get closed tickets method was called");

        List<TicketDTO> ticketDTOList = ticketService.getClosedTicketList();

        log.debug("get closed tickets method returns {}", ticketDTOList);

        return ticketDTOList;
    }

    @PostMapping("/sortByRecentlyOpenedTickets")
    @ApiOperation("Список заявок, отсортированный по дате создания")
    public List<TicketDTO> getTicketsSortedByOpening() {

        log.debug("sort tickets by opening time method was called");

        List<TicketDTO> ticketDTOList = ticketService.getRecentTicketList();

        log.debug("sort tickets by opening time method returns {}", ticketDTOList);

        return ticketDTOList;
    }
}
