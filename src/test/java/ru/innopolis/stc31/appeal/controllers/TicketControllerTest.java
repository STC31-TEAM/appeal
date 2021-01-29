package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.TicketDTOToTicket;
import ru.innopolis.stc31.appeal.converters.TicketToTicketDTO;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;
import ru.innopolis.stc31.appeal.services.TicketService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Spy
    private TicketDTOToTicket ticketDTOToTicket;

    @Spy
    private TicketToTicketDTO ticketToTicketDTO;


    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllTickets());
        assertDoesNotThrow(() -> controller.createTicket(MockUtils.makeTicketDTO()));
    }

    @Test
    void getAllTicketsWithOk() {
        List<TicketDTO> tickets = MockUtils.makeListTicketDTO(5);
        when(service.getTicketList()).thenReturn(tickets);

        assertEquals(tickets.size(), controller.getAllTickets().size());
    }

    @Test
    void createTicketWithOk() {
        LocalDate dateOpen = LocalDate.of(2021, 1, 22);
        LocalDate dateClose = LocalDate.of(2021, 1, 23);

        TicketDTO ticketDTO = new TicketDTO(1,1,1,1,1,1,1,1,
                "TestTicket1","TestTicketDescription1",dateOpen,dateClose,
                10,1,(short)0, new CompanyDTO(), new CityDTO());

        Ticket ticket=ticketDTOToTicket.convert(ticketDTO);

        when(service.createTicket(ticketDTO)).thenReturn(ticket);

        ResponseEntity<TicketDTO> responseEntity=controller.createTicket(ticketDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getId(), ticketDTO.getId());

    }
}