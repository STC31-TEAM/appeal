package ru.innopolis.stc31.appeal.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.services.ServiceTypesService;

import java.util.List;

/**
 * Controller for manage type of services
 */
@RestController
@AllArgsConstructor
@RequestMapping("${application.api.uriPrefix}/type-of-service")
public class ServiceTypeController {

    /** Service type service instance */
    private final ServiceTypesService serviceTypesService;

    /**
     * Get list of all type of services
     *
     * @return List of type of services
     */
    @GetMapping("/all")
    @ApiOperation("Получить список всех типов услуг")
    public List<ServiceTypeDTO> getAllServiceTypes() {
        return serviceTypesService.getTypeOfServiceList();
    }

    /**
     * Create new type of service
     *
     * @param dto Model
     * @return true if success created
     */
    @PostMapping("/create")
    @ApiOperation("Добавить тип услуги")
    public ServiceTypeDTO createServiceType(@RequestBody ServiceTypeDTO dto) {
        return serviceTypesService.createTypeOfService(dto);
    }

    /**
     * Update type of service
     *
     * @param dto Model
     * @return true if success created
     */
    @PutMapping("/update")
    @ApiOperation("Добавить тип услуги")
    public ServiceTypeDTO updateServiceType(@RequestBody ServiceTypeDTO dto) {
        return serviceTypesService.updateTypeOfService(dto);
    }

    /**
     * Delete new type of service
     *
     * @param dto Model
     * @return true if success created
     */
    @DeleteMapping("/delete")
    @ApiOperation("Добавить тип услуги")
    public ServiceTypeDTO deleteServiceType(@RequestBody ServiceTypeDTO dto) {
        return serviceTypesService.deleteTypeOfService(dto);
    }
}
