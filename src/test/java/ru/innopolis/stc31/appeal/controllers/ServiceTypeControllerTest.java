package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.services.ServiceTypesService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Testing ServiceTypeController
 */
@SpringJUnitConfig
class ServiceTypeControllerTest {

    @InjectMocks
    private ServiceTypeController controller;

    @Mock
    private ServiceTypesService service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllServiceTypes());
        assertDoesNotThrow(() -> controller.createServiceType(MockUtils.makeServiceTypeDTO()));
    }

    @Test
    void getAllServiceTypesWithOk() {
        List<ServiceTypeDTO> serviceTypes = MockUtils.makeListServiceTypeDTO(5);
        when(service.getTypeOfServiceList()).thenReturn(serviceTypes);

        assertEquals(serviceTypes.size(), controller.getAllServiceTypes().size());
    }

    @Test
    void createServiceTypeWithOk() {
        ServiceTypeDTO serviceType = MockUtils.makeServiceTypeDTO();

        when(service.createTypeOfService(serviceType)).thenReturn(true);

        assertTrue(controller.createServiceType(serviceType));
    }
}
