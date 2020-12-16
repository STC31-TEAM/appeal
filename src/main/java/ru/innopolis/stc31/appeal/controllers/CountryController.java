package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage countries
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/country")
public class CountryController {
    /**
     * Get list of all countries
     *
     * @return List of countries
     */
    @GetMapping("/all")
    public List<CountryDTO> all() {
        // TODO: get all countries
        return null;
    }

    /**
     * Create new country
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody CountryDTO dto) {
        // TODO: save country
        return false;
    }
}
