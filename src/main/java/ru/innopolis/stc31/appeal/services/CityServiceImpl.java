package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.CityDTOToCity;
import ru.innopolis.stc31.appeal.converters.CityToCityDTO;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.entity.City;
import ru.innopolis.stc31.appeal.repository.CityRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;
    private final CityDTOToCity cityDTOToCity;
    private final CityToCityDTO cityToCityDTO;

    @Override
    public List<CityDTO> getCityList() {
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> cityDTOList = new ArrayList<>();
        for (City city : cityList) {
            cityDTOList.add(cityToCityDTO.convert(city));
        }
        return cityDTOList;
    }

    @Override
    public City createCity(CityDTO cityDTO) {
        return cityRepository.save(cityDTOToCity.convert(cityDTO));
    }

    @Override
    public boolean deleteCity(CityDTO cityDTO) {
        cityRepository.deleteById(cityDTO.getId());
        return true;
    }
}
