package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.ReviewService;

import java.util.Map;

/**
 * UI controller for review page
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class ReviewController extends BaseCredentialController {

    private final ReviewService reviewService;

    @GetMapping("/")
    public String welcome(Model model) {
        return "index";
    }

    @GetMapping("/createUserOrCompany")
    public String createUser(Model model) {
        UserDTO userDTO = new UserDTO();
        CompanyDTO companyDTO = new CompanyDTO();
        model.addAttribute("companyDTO", companyDTO);
        model.addAttribute("userDTO", userDTO);
        Map<String, Long> mapCompany = reviewService.getAllCompanyTitle();
        model.addAttribute("allCompanyTitle", mapCompany);
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
        return "list-ticket";
    }

    @GetMapping("/createTicket")
    public String createTicket(Model model) {
        TicketDTO ticketDTO = new TicketDTO();
        model.addAttribute("ticketDTO", ticketDTO);
        Map<String, Long> mapCompany = reviewService.getAllCompanyTitle();
        model.addAttribute("allCompanyTitle", mapCompany);
        model.addAttribute("allCountryTitle", reviewService.getAllCountryName());
        model.addAttribute("allCityName", reviewService.getAllCityName());
        model.addAttribute("allStreetName", reviewService.getAllStreetName());
        model.addAttribute("allServiceType", reviewService.getAllServiceType());
        return "create-ticket";
    }
}
