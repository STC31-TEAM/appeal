package ru.innopolis.stc31.appeal.controllers.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.TicketDTO;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.services.ReviewService;

import java.util.ArrayList;
import java.util.List;
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
        List<TicketDTO> closedTickets = getClosedTicketsList();
        List<TicketDTO> recentTickets = getRecentTicketsList();
        List<CompanyDTO> topCompanies = getTopCompaniesList();

        model.addAttribute("closedTickets", closedTickets);
        model.addAttribute("recentTickets", recentTickets);
        model.addAttribute("topCompanies", topCompanies);
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

    /**
     * Temp data stub
     * TODO: Must be removed
     *
     * @return Closed tickets
     */
    private List<TicketDTO> getClosedTicketsList() {
        List<TicketDTO> tickets = new ArrayList<>();

        tickets.add(new TicketDTO()
                .setTitles("Открыть магазин одежды")
                .setDescription("В северной части города нет ни одного магазина одежды.")
                .setCountLikes(100)
                .setCountDisLikes(43)
                .setCompanyDTO(new CompanyDTO().setTitle("O`Stin"))
                .setCityDTO(new CityDTO().setCityName("г. Уфа"))
        );

        tickets.add(new TicketDTO()
                .setTitles("Построить автомойку")
                .setDescription("На весь город одна автомойка. Хотим ещё.")
                .setCountLikes(37)
                .setCountDisLikes(23)
                .setCompanyDTO(new CompanyDTO().setTitle("Автопилот"))
                .setCityDTO(new CityDTO().setCityName("г. Алапаевск"))
        );

        return tickets;
    }

    /**
     * Temp data stub
     * TODO: Must be removed
     *
     * @return Recent tickets
     */
    private List<TicketDTO> getRecentTicketsList() {
        List<TicketDTO> tickets = new ArrayList<>();

        tickets.add(new TicketDTO()
                .setTitles("Ремонт моста")
                .setDescription("Под мост начали проваливаться машины. Не хорошо.")
                .setCountLikes(55)
                .setCountDisLikes(43)
                .setCityDTO(new CityDTO().setCityName("г. Тюмень"))
        );

        tickets.add(new TicketDTO()
                .setTitles("Открыть подпольное казино")
                .setDescription("Не помешает.")
                .setCountLikes(25)
                .setCountDisLikes(43)
                .setCityDTO(new CityDTO().setCityName("г. Новый Уренгой"))
        );

        tickets.add(new TicketDTO()
                .setTitles("Почистить озеро")
                .setDescription("Не возможно купаться.")
                .setCountLikes(63)
                .setCountDisLikes(43)
                .setCityDTO(new CityDTO().setCityName("г. Ялуторовск"))
        );

        tickets.add(new TicketDTO()
                .setTitles("Вырубить лес")
                .setDescription("Бегают волки.")
                .setCountLikes(32)
                .setCountDisLikes(43)
                .setCityDTO(new CityDTO().setCityName("с. Заблудкино"))
        );

        tickets.add(new TicketDTO()
                .setTitles("Построить пиццерию")
                .setDescription("В селе не где поесть.")
                .setCountLikes(76)
                .setCountDisLikes(43)
                .setCityDTO(new CityDTO().setCityName("с. Заблудкино"))
        );

        return tickets;
    }

    /**
     * Temp data stub
     * TODO: Must be removed
     *
     * @return Top companies
     */
    private List<CompanyDTO> getTopCompaniesList() {
        List<CompanyDTO> companies = new ArrayList<>();

        companies.add(new CompanyDTO()
                .setTitle("ПАО «Газпром»")
                .setCountClosedTickets(54)
        );

        companies.add(new CompanyDTO()
                .setTitle("ПАО «ВТБ»")
                .setCountClosedTickets(35)
        );

        companies.add(new CompanyDTO()
                .setTitle("ПАО «Сбербанк»")
                .setCountClosedTickets(29)
        );

        companies.add(new CompanyDTO()
                .setTitle("ПАО НК \"Роснефть\"")
                .setCountClosedTickets(18)
        );

        companies.add(new CompanyDTO()
                .setTitle("ООО «СтройТрансГрупп»")
                .setCountClosedTickets(12)
        );

        return companies;
    }
}
