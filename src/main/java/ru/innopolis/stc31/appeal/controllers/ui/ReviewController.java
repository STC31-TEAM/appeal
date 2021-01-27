package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.ReviewService;

/**
 * UI controller for review page
 */
@Slf4j
@AllArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("messagePart", "Appeal application");
        return "index";
    }

    @GetMapping("/createUserOrCompany")
    public String createUser(Model model) {
        UserDTO userDTO = new UserDTO();
        CompanyDTO companyDTO = new CompanyDTO();
        model.addAttribute("companyDTO", companyDTO);
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("allCompanyTitle", reviewService.getAllCompanyTitle());
        model.addAttribute("allCountryTitle", reviewService.getAllCountryName());
        model.addAttribute("allCityName", reviewService.getAllCityName());
        model.addAttribute("allStreetName", reviewService.getAllStreetName());
        return "create-user-or-company";
    }

    @GetMapping("/companyAll")
    public String companyAll(Model model) {
        CompanyDTO companyDTO = new CompanyDTO();
        model.addAttribute("companyDTO", companyDTO);
        model.addAttribute("allCompany", reviewService.getAllCompany());
        return "list-company";
    }

    @GetMapping("/ticketAll")
    public String ticketAll(Model model) {
        TicketDTO ticketDTO = new TicketDTO();
        model.addAttribute("ticketDTO", ticketDTO);
        model.addAttribute("allTicket", reviewService.getAllTickets());
        return "list-company";
    }
}
