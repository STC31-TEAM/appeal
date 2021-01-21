package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;

@Component
public class ServiceTypeDTOToServiceType implements Converter<ServiceTypeDTO, ServiceType> {

    /**
     * Do not specify id because when creating a record sql will create it automatically, otherwise it will try to find a relationship and possibly errors
     * If you need to specify id for the update query, then specify it manually
     *
     * @param source RoleDTO instance
     * @return Role instance
     */
    @Override
    public ServiceType convert(ServiceTypeDTO source) {
        return new ServiceType()
                .setType(source.getType())
                .setDescription(source.getDescription());
    }
}
