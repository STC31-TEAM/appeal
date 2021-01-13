package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.ServiceTypeDTO;

import java.util.List;

@Service
public class ServiceTypesServiceImpl implements ServiceTypesService {
    @Override
    public List<ServiceTypeDTO> getTypeOfServiceList() {
        return null;
    }

    @Override
    public boolean createTypeOfService(ServiceTypeDTO serviceTypeDTO) {
        return false;
    }

    @Override
    public boolean deleteTypeOfService(ServiceTypeDTO serviceTypeDTO) {
        return false;
    }
}
