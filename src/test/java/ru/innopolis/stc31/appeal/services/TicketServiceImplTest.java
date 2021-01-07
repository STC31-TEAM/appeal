package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing TicketServiceImpl
 */
@SpringJUnitConfig
class TicketServiceImplTest {

    @InjectMocks
    private TicketServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createTicket(MockUtils.makeTicketDTO()));
        assertDoesNotThrow(() -> service.deleteTicket(MockUtils.makeTicketDTO()));
        assertDoesNotThrow(() -> service.getTicketList());
    }
}
