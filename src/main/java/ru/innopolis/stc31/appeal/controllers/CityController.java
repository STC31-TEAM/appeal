package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.services.CityService;

import java.util.List;

/**
 * Controller for manage cities
 *
 * @author Sergey Fomin
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/city")
public class CityController {
    /**
     * Service instance
     */
    protected final CityService cityService;

    /**
     * Get list of all cities
     *
     * @return List of cities
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех городов")
    public List<CityDTO> all() {
        return cityService.getCityList();
    }

    /**
     * Create new city
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить новый город")
    public boolean create(@RequestBody CityDTO dto) {
        return cityService.createCity(dto);
    }
}
