package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.StreetDTOToStreet;
import ru.innopolis.stc31.appeal.converters.StreetToStreetDTO;
import ru.innopolis.stc31.appeal.model.dto.StreetDTO;
import ru.innopolis.stc31.appeal.model.entity.Street;
import ru.innopolis.stc31.appeal.repository.StreetRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class StreetServiceImpl implements StreetService{

    private final StreetRepository streetRepository;
    private final StreetDTOToStreet streetDTOToStreet;
    private final StreetToStreetDTO streetToStreetDTO;


    @Override
    public List<StreetDTO> getStreetList() {
        List<Street> streetList = streetRepository.findAll();
        List<StreetDTO> streetDTOList = new ArrayList<>();
        for (Street e: streetList){
            streetDTOList.add(streetToStreetDTO.convert(e));
        }
        return streetDTOList;
    }

    @Override
    public Street createStreet(StreetDTO streetDTO) {
        return streetRepository.save(streetDTOToStreet.convert(streetDTO));
    }

    @Override
    public boolean deleteStreet(StreetDTO streetDTO) {
        streetRepository.deleteById(streetDTO.getId());
        return true;
    }
}
