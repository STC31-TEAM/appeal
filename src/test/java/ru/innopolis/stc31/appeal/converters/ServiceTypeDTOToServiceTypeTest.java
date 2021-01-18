package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class ServiceTypeDTOToServiceTypeTest {

    @InjectMocks
    private ServiceTypeDTOToServiceType serviceTypeDTOToServiceType;

    @Test
    void convert() {
        ServiceTypeDTO serviceTypeDTO = MockUtils.makeServiceTypeDTO();
        assertEquals(0, Objects.requireNonNull(serviceTypeDTOToServiceType.convert(serviceTypeDTO)).getId());
    }
}