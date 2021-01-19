package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;
import ru.innopolis.stc31.appeal.repository.ServiceTypeRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

/**
 * Testing ServiceTypesServiceImpl
 */
@SpringJUnitConfig
class ServiceTypesServiceImplTest {

    @InjectMocks
    private ServiceTypesServiceImpl service;

    @Spy
    private ConversionService conversionService;

    @Spy
    private ServiceTypeRepository repository;

    @Test
    void checkOnOk() {
        ServiceTypeDTO serviceTypeDTO = MockUtils.makeServiceTypeDTO();
        ServiceType serviceType = MockUtils.makeServiceTypeEntity();
        when(conversionService.convert(serviceTypeDTO, ServiceType.class)).thenReturn(serviceType);

        assertDoesNotThrow(() -> service.updateTypeOfService(serviceTypeDTO));
        assertDoesNotThrow(() -> service.createTypeOfService(serviceTypeDTO));
        assertDoesNotThrow(() -> service.deleteTypeOfService(serviceTypeDTO));
        assertDoesNotThrow(() -> service.getTypeOfServiceList());
    }
}