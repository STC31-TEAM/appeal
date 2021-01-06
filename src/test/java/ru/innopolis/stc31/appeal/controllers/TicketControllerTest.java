package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.services.TicketService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing TicketController
 */
@SpringJUnitConfig
class TicketControllerTest {

    @InjectMocks
    private TicketController controller;

    @Mock
    private TicketService service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllTickets());
        assertDoesNotThrow(() -> controller.createTicket(new TicketDTO()));
    }

    @Test
    void getAllTicketsWithOk() {
        List<TicketDTO> tickets = MockUtils.makeListTicketDTO(5);
        when(service.getTicketList()).thenReturn(tickets);

        assertEquals(tickets.size(), controller.getAllTickets().size());
    }

    @Test
    void createTicketWithOk() {
        TicketDTO ticket = MockUtils.makeTicketDTO();

        when(service.createTicket(ticket)).thenReturn(true);

        assertTrue(controller.createTicket(ticket));
    }
}