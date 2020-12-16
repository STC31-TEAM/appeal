package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage streets
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/street")
public class StreetController {
    /**
     * Get list of all streets
     *
     * @return List of streets
     */
    @GetMapping("/all")
    public List<StreetDTO> all() {
        // TODO: get all streets
        return null;
    }

    /**
     * Create new street
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody StreetDTO dto) {
        // TODO: save street
        return false;
    }
}
