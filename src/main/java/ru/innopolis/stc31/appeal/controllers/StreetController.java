package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.services.StreetService;

import java.util.List;

/**
 * Controller for manage streets
 *
 * @author Sergey Fomin
 */
@RestController
@RequestMapping("${application.api.uriPrefix}/street")
public class StreetController {
    /**
     * Service instance
     */
    protected StreetService streetService;

    /**
     * Get list of all streets
     *
     * @return List of streets
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех улиц")
    public List<StreetDTO> all() {
        return streetService.getStreetList();
    }

    /**
     * Create new street
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить улицу")
    public boolean create(@RequestBody StreetDTO dto) {
        return streetService.createStreet(dto);
    }
}
