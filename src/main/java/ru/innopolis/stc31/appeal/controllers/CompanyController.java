package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.services.CompanyService;

import java.util.List;

/**
 * Controller for manage companies
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("${application.api.uriPrefix}/company")
public class CompanyController {
    /**
     * Service instance
     */
    protected CompanyService companyService;

    /**
     * Get list of all companies
     *
     * @return List of companies
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех компаний")
    public List<CompanyDTO> all() {
        return companyService.getCompanyList();
    }

    /**
     * Create new company
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить компанию")
    public boolean create(@RequestBody CompanyDTO dto) {
        return companyService.createCompany(dto);
    }
}
