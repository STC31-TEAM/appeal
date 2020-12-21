package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.services.CountryService;

import java.util.List;

/**
 * Controller for manage countries
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("${application.api.uriPrefix}/country")
public class CountryController {
    /**
     * Service instance
     */
    protected CountryService countryService;

    /**
     * Get list of all countries
     *
     * @return List of countries
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех стран")
    public List<CountryDTO> all() {
        return countryService.getCountyList();
    }

    /**
     * Create new country
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить страну")
    public boolean create(@RequestBody CountryDTO dto) {
        return countryService.createCounty(dto);
    }
}
