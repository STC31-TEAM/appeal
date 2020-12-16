package ru.innopolis.stc31.appeal.controllers;

import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.TypeOfServiceDTO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for manage type of services
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("/type-of-service")
public class TypeOfServiceController {
    /**
     * Get list of all type of services
     *
     * @return List of type of services
     */
    @GetMapping("/all")
    public List<TypeOfServiceDTO> all() {
        // TODO: get all type of services
        return null;
    }

    /**
     * Create new type of service
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    public boolean create(@RequestBody TypeOfServiceDTO dto) {
        // TODO: save type
        return false;
    }
}
