package ru.innopolis.stc31.appeal.controllers.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
