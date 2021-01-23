package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.TicketDTOToTicket;
import ru.innopolis.stc31.appeal.converters.TicketToTicketDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;
import ru.innopolis.stc31.appeal.repository.TicketRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testing TicketServiceImpl
 */
@SpringJUnitConfig
class TicketServiceImplTest {

    @InjectMocks
    private TicketServiceImpl service;
    @Mock
    private TicketRepository ticketRepository;

    @Spy
    private TicketDTOToTicket ticketDTOToTicket;

    @Spy
    private TicketToTicketDTO ticketToTicketDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createTicket(MockUtils.makeTicketDTO()));
        assertDoesNotThrow(() -> service.deleteTicket(MockUtils.makeTicketDTO()));
        assertDoesNotThrow(() -> service.getTicketList());
    }

    @Test
    void getTicketList() {
        List<Ticket> ticketList = new ArrayList<>();

        LocalDate dateOpen = LocalDate.of(2021, 1, 17);
        LocalDate dateClose = LocalDate.of(2021, 1, 21);
        for (int count = 1; count < 6; count++) {
            ticketList.add(new Ticket(count, count * 2, count * 3, count * 3, count * 4, count * 4,
                    count * 5, count * 5, "TestTitles" + count, "TestDescription1" + count,
                    (short) 1, dateOpen, dateClose, 10, 1));


        }

            when(ticketRepository.findAll()).thenReturn(ticketList);
            List<TicketDTO> ticketDTOList = service.getTicketList();
            assertEquals(ticketList.size(), ticketDTOList.size());
            assertEquals(ticketList.get(1).getTitle(), ticketDTOList.get(1).getTitles());
            assertEquals(ticketList.get(1).getOpenedOn(), ticketDTOList.get(1).getOpenDate());
            assertEquals(ticketList.get(1).getClosedOn(), ticketDTOList.get(1).getCloseDate());
            assertEquals(ticketList.get(1).getStatus(), ticketDTOList.get(1).getStatus());

    }

}
