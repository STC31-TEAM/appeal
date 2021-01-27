package ru.innopolis.stc31.appeal.controllers.ui;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.stc31.appeal.exceptions.CompanyErrors;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.services.CompanyService;

@Controller
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/ui/company")
@Slf4j
public class CompanyUiController {

    /** Company service instance */
    private final CompanyService companyService;


    /**
     * Create new company
     *
     * @param companyDTO Model
     * @param model Model
     * @return true if success created
     */
    @PostMapping("/createCompany")
    @ApiOperation("Добавить компанию")
    public String createCompany(CompanyDTO companyDTO, Model model) {

        log.debug("create company method was called with {} ", companyDTO);

        try {
            Company company = companyService.createCompany(companyDTO);
            if (company == null){
                ErrorMessage errorMessage = new ErrorMessage(-4,
                        "Не удалось создать запись, исходные данные: " + companyDTO);
                throw new CompanyErrors(errorMessage);
            }
            log.debug("create company method return result {} ", company);
        } catch (CompanyErrors companyErrors) {
            log.error(companyErrors.getErrorMessage().getErrorMessage());
            return "create-fail";
        } catch (Exception exception) {
            log.error(exception.getMessage());
            return "create-fail";
        }
        return "create-success";
    }
}
