package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class ServiceTypeToServiceTypeDTOTest {

    @InjectMocks
    private ServiceTypeToServiceTypeDTO serviceTypeToServiceTypeDTO;

    @Test
    void convert() {
        ServiceType serviceType = MockUtils.makeServiceTypeEntity();
        assertEquals(Objects.requireNonNull(serviceTypeToServiceTypeDTO.convert(serviceType)).getId(), serviceType.getId());
    }
}