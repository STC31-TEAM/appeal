package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage companies
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    /**
     * Get list of all companies
     *
     * @return List of companies
     */
    @GetMapping("/all")
    public List<CompanyDTO> all() {
        // TODO: get all companies
        return null;
    }

    /**
     * Create new company
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody CompanyDTO dto) {
        // TODO: save company
        return false;
    }
}
