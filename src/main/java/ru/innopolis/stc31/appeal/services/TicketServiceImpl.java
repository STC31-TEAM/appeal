package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{
    @Override
    public List<TicketDTO> getTicketList() {
        return null;
    }

    @Override
    public boolean createTicket(TicketDTO ticketDTO) {
        return false;
    }

    @Override
    public boolean deleteTicket(TicketDTO ticketDTO) {
        return false;
    }
}
