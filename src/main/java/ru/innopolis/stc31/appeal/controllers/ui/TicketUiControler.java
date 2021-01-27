package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.entity.Ticket;
import ru.innopolis.stc31.appeal.services.TicketService;

@Controller
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/ui")
@Slf4j
public class TicketUiControler {

    private final TicketService ticketService;

    public String createTicket(TicketDTO ticketDTO, Model model) {

        Ticket ticket = ticketService.createTicket(ticketDTO);

        if (ticket == null) {
            return "ticket-create-fail";
        }

        return "ticket-create-success";
    }
}
