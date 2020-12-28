package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
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
    public ResponseEntity<String> create(@RequestBody StreetDTO dto) {

        log.debug("@RequestBody: " + dto.toString());

        var isCreated = streetService.createStreet(dto);

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
    @ApiOperation("Удалить улицу")
    public ResponseEntity<String> delete(@RequestBody StreetDTO dto) {

        log.debug("@RequestBody: " + dto.toString());

        var isRemoved = streetService.deleteStreet(dto);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        log.debug("Result: Success");
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
