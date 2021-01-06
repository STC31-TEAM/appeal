package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.CountryToCountryDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
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
@RequestMapping("${application.api.uriPrefix}/user/country")
@Slf4j
public class CountryController {

    /** Service instance   */
    private final CountryService countryService;
    private final CountryToCountryDTO countryToCountryDTO;

    /**
     * Get list of all countries
     *
     * @return List of countries
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех стран")
    public List<CountryDTO> all() {
        return countryService.getCountryList();
    }

    /**
     * Create new country
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить страну")
    public ResponseEntity<CountryDTO> create(@RequestBody CountryDTO dto) {

        log.debug("create country method was called with {} ", dto);

        var country = countryService.createCountry(dto);

        if (country == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("create country method return result {} ", country);
        return new ResponseEntity<>(countryToCountryDTO.convert(country), HttpStatus.OK);
    }

    /**
     * Delete street
     *
     * @param dto Model
     * @return true if success deleted
     */
    @DeleteMapping("/delete")
    @ApiOperation("Удалить страну")
    public ResponseEntity<SuccessModel> delete(@RequestBody CountryDTO dto) {

        log.debug("delete country method was called with {} ", dto);

        var isRemoved = countryService.deleteCountry(dto);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SuccessModel successModel = new SuccessModel().setResult("OK");

        log.debug("delete country method return result {} ", successModel);
        return new ResponseEntity<>(successModel, HttpStatus.OK);
    }
}
