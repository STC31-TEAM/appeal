package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;

import java.util.List;

/**
 * interface for Ticket services
 *
 * @author v.shulepov
 */
public interface TicketService {
    /**
     * return list of all tickets
     * @return list of tickets
     */
    List<TicketDTO> getTicketList();

    /**
     * create new ticket
     * @param ticketDTO ticket
     * @return result of operation
     */
    Ticket createTicket(TicketDTO ticketDTO);

    /**
     * delete ticket from base
     * @param ticketDTO ticket needed to remove
     * @return result of operation
     */
    boolean deleteTicket(TicketDTO ticketDTO);
}
