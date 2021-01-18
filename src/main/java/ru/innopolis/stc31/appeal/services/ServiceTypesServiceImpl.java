package ru.innopolis.stc31.appeal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;
import ru.innopolis.stc31.appeal.repository.ServiceTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTypesServiceImpl implements ServiceTypesService {

    private final ServiceTypeRepository repository;
    private final ConversionService conversionService;

    public ServiceTypesServiceImpl(@Autowired ServiceTypeRepository repository,
                           @Qualifier("mvcConversionService") ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public List<ServiceTypeDTO> getTypeOfServiceList() {
        List<ServiceTypeDTO> result = new ArrayList<>();
        repository.findAll().forEach(serviceType -> result.add(conversionService.convert(serviceType, ServiceTypeDTO.class)));
        return result;
    }

    @Override
    public ServiceTypeDTO createTypeOfService(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = conversionService.convert(serviceTypeDTO, ServiceType.class);
        assert serviceType != null;
        repository.save(serviceType);
        return serviceTypeDTO;
    }

    @Override
    public ServiceTypeDTO updateTypeOfService(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = conversionService.convert(serviceTypeDTO, ServiceType.class);
        assert serviceType != null;
        serviceType.setId(serviceTypeDTO.getId());
        repository.save(serviceType);
        return serviceTypeDTO;
    }

    @Override
    public ServiceTypeDTO deleteTypeOfService(ServiceTypeDTO serviceTypeDTO) {
        repository.deleteById(serviceTypeDTO.getId());
        return serviceTypeDTO;
    }
}
