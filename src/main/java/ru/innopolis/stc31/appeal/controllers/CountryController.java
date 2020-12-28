package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.services.CountryService;

import java.util.List;

/**
 * Controller for manage countries
 *
 * @author Sergey Fomin
 *
 */
@AllArgsConstructor
@RestController
@RequestMapping("${application.api.uriPrefix}/country")
@Slf4j
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
    public ResponseEntity<String> create(@RequestBody CountryDTO dto) {

        log.debug("@RequestBody: " + dto.toString());

        var isCreated = countryService.createCounty(dto);

        if (!isCreated) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("Result: Success");
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    /**
     * Delete street
     *
     * @param dto Model
     * @return true if success deleted
     */
    @DeleteMapping("/delete")
    @ApiOperation("Удалить страну")
    public ResponseEntity<String> delete(@RequestBody CountryDTO dto) {

        var isRemoved = countryService.deleteCounty(dto);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
