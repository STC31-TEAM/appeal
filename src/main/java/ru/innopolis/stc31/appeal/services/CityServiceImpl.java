package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Override
    public List<CityDTO> getCityList() {
        return null;
    }

    @Override
    public boolean createCity(CityDTO cityDTO) {
        return false;
    }

    @Override
    public boolean deleteCity(CityDTO cityDTO) {
        return false;
    }
}
