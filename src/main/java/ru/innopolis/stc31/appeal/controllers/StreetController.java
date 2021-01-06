package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.converters.StreetToStreetDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.services.StreetService;

import java.util.List;

/**
 * Controller for manage streets
 *
 * @author Sergey Fomin
 */

@AllArgsConstructor
@RestController
@RequestMapping("${application.api.uriPrefix}/street")
@Slf4j
public class StreetController {
    /**
     * Service instance
     */
    private final StreetService streetService;
    private final StreetToStreetDTO streetToStreetDTO;

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
    public ResponseEntity<StreetDTO> create(@RequestBody StreetDTO dto) {

        log.debug("create street method was called with {} ", dto);

        var street = streetService.createStreet(dto);

        if (street == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("create street method return result {} ", street);
        return new ResponseEntity<>(streetToStreetDTO.convert(street), HttpStatus.OK);
    }

    /**
     * Delete street
     *
     * @param dto Model
     * @return true if success deleted
     */
    @DeleteMapping("/delete")
    @ApiOperation("Удалить улицу")
    public ResponseEntity<SuccessModel> delete(@RequestBody StreetDTO dto) {

        log.debug("delete street method was called with {} ", dto);

        var isRemoved = streetService.deleteStreet(dto);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SuccessModel successModel = new SuccessModel().setResult("OK");
        log.debug("delete street method return result {} ", successModel);
        return new ResponseEntity<>(successModel, HttpStatus.OK);
    }
}
