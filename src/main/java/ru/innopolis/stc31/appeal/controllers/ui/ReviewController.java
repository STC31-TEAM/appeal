package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.services.ReviewService;

/**
 * UI controller for review page
 */
@Controller
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("messagePart", "Appeal application");
        return "index";
    }

    @GetMapping("/ticketAll")
    public String ticketAll(Model model) {
        TicketDTO ticketDTO = new TicketDTO();
        model.addAttribute("companyDTO", ticketDTO);
        model.addAttribute("allCompany", reviewService.getAllTickets());
        return "list-company";
    }
}
