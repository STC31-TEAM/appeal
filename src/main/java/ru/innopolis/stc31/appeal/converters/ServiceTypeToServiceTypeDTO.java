package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;

@Component
public class ServiceTypeToServiceTypeDTO implements Converter<ServiceType, ServiceTypeDTO> {

    @Override
    public ServiceTypeDTO convert(ServiceType source) {
        return new ServiceTypeDTO()
                .setId(source.getId())
                .setType(source.getType());
    }
}
