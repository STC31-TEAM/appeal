package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.exceptions.CompanyErrors;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.services.CompanyService;

import java.util.List;

/**
 * Controller for manage companies
 */
@Controller
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/company")
@Slf4j
public class CompanyController {

    /** Company service instance */
    private final CompanyService companyService;

    private final CompanyToCompanyDTO companyToCompanyDTO;

    /**
     * Get list of all companies
     *
     * @return List of companies
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех компаний")
    public List<CompanyDTO> getAllCompanies() {
        return companyService.getCompanyList();
    }

    /**
     * Create new company
     *
     * @param companyDTO Model
     * @return true if success created
     */
    @PostMapping("/createCompany")
    @ApiOperation("Добавить компанию")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {

        log.debug("create company method was called with {} ", companyDTO);

        var company = companyService.createCompany(companyDTO);
        if (company == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("create company method return result {} ", company);
        return new ResponseEntity<>(companyToCompanyDTO.convert(company), HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation("Удалить компанию")
    public ResponseEntity<SuccessModel> deleteCompany(@RequestBody CompanyDTO companyDTO) {

        log.debug("delete company method was called with {}", companyDTO);

        boolean isRemoved = companyService.deleteCompany(companyDTO);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SuccessModel successModel = new SuccessModel().setResult("OK");
        log.debug("delete company method return result {}", successModel);
        return new ResponseEntity<>(successModel, HttpStatus.OK);
    }

    @PostMapping("/findByCountry")
    @ApiOperation("Найти компании по стране")
    public List<CompanyDTO> getCountryByCountry (@RequestBody CountryDTO countryDTO) {

        log.debug("find company method was called with {}", countryDTO);

        List<CompanyDTO> companyDTOList = companyService.getCompanyListByCountry(countryDTO);

        log.debug("find company method return result {}", companyDTOList);

        return companyDTOList;
    }

    @PostMapping("/sortByCompletedTickerts")
    @ApiOperation("Список компаний отсортированный по количеству выполенныех заявок")
    public List<CompanyDTO> getCompaniesSortedByCompletedTickets() {

        log.debug("sort company by completed tickets method was called");

        List<CompanyDTO> companyDTOList = companyService.getCompaniesSortedByCompletedTickets();

        log.debug("sort company by completed tickets method return {}", companyDTOList);

        return companyDTOList;
    }
}
