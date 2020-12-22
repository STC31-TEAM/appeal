package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.TypeOfServiceDTO;
import ru.innopolis.stc31.appeal.services.TypeOfServicesService;

import java.util.List;

/**
 * Controller for manage type of services
 *
 * @author Sergey Fomin
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/type-of-service")
public class TypeOfServiceController {
    /**
     * Service instance
     */
    private final TypeOfServicesService typeOfServicesService;

    /**
     * Get list of all type of services
     *
     * @return List of type of services
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех типов услуг")
    public List<TypeOfServiceDTO> all() {
        return typeOfServicesService.getTypeOfServiceList();
    }

    /**
     * Create new type of service
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить тип услуги")
    public boolean create(@RequestBody TypeOfServiceDTO dto) {
        return typeOfServicesService.createTypeOfService(dto);
    }
}
