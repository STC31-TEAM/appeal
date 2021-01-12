package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing ServiceTypesServiceImpl
 */
@SpringJUnitConfig
class ServiceTypesServiceImplTest {

    @InjectMocks
    private ServiceTypesServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createTypeOfService(MockUtils.makeServiceTypeDTO()));
        assertDoesNotThrow(() -> service.deleteTypeOfService(MockUtils.makeServiceTypeDTO()));
        assertDoesNotThrow(() -> service.getTypeOfServiceList());
    }
}