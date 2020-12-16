package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage cities
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/city")
public class CityController {
    /**
     * Get list of all cities
     *
     * @return List of cities
     */
    @GetMapping("/all")
    public List<CityDTO> all() {
        // TODO: get all cities
        return null;
    }

    /**
     * Create new city
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody CityDTO dto) {
        // TODO: save album
        return false;
    }
}
