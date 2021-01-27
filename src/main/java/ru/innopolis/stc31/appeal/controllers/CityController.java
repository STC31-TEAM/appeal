package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.CityToCityDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.services.CityService;

import java.util.List;

/**
 * Controller for manage cities
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/city")
@Slf4j
public class CityController {

    /** City service instance */
    protected final CityService cityService;

    private final CityToCityDTO cityToCityDTO;

    /**
     * Get list of all cities
     *
     * @return List of cities
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех городов")
    public List<CityDTO> getAllCities() {
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
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO dto) {

        log.debug("create city method was called with {}", dto);

        var city = cityService.createCity(dto);
        if (city == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        log.debug("creaty city method return result {}", city);
        return new ResponseEntity<>(cityToCityDTO.convert(city),HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ApiOperation("Удалить город")
    public ResponseEntity<SuccessModel> deleteCity(@RequestBody CityDTO cityDTO) {

        log.debug("delete city method was called with {} ", cityDTO);

        var isRemoved = cityService.deleteCity(cityDTO);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SuccessModel successModel = new SuccessModel().setResult("OK");
        log.debug("delete album method return result {} ", successModel);
        return new ResponseEntity<>(successModel, HttpStatus.OK);
    }
}
