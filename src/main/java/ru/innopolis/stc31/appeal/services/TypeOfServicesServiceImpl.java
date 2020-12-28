package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.TypeOfServiceDTO;

import java.util.List;

@Service
public class TypeOfServicesServiceImpl implements TypeOfServicesService{
    @Override
    public List<TypeOfServiceDTO> getTypeOfServiceList() {
        return null;
    }

    @Override
    public boolean createTypeOfService(TypeOfServiceDTO typeOfServiceDTO) {
        return false;
    }

    @Override
    public boolean deleteTypeOfService(TypeOfServiceDTO typeOfServiceDTO) {
        return false;
    }
}
