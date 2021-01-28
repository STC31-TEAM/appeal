package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;
import ru.innopolis.stc31.appeal.converters.TicketDTOToTicket;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;
import ru.innopolis.stc31.appeal.services.TicketService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class TicketUiControlerTest {

    @InjectMocks
    private TicketUiControler ticketUiControler;

    @Spy
    private TicketService ticketService;

    @Spy
    private TicketDTOToTicket ticketDTOToTicket;

    @Mock
    private Model model;

    @Test
    void createTicketReturnSuccess() {
        TicketDTO ticketDTO = MockUtils.makeTicketDTO();
        Ticket ticket = ticketDTOToTicket.convert(ticketDTO);
        when(ticketService.createTicket(ticketDTO)).thenReturn(ticket);

        String view = ticketUiControler.createTicket(ticketDTO, model);

        assertNotNull(view);
        assertEquals(view, "ticket-create-success");
    }

    @Test
    void createTicketReturnFail() {
        TicketDTO ticketDTO = MockUtils.makeTicketDTO();
        Ticket ticket = ticketDTOToTicket.convert(ticketDTO);

        String view = ticketUiControler.createTicket(ticketDTO, model);

        assertNotNull(view);
        assertEquals(view, "ticket-create-fail");
    }
}