package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.CountryDTOToCountry;
import ru.innopolis.stc31.appeal.converters.CountryToCountryDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Country;
import ru.innopolis.stc31.appeal.repository.CountryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;
    private final CountryToCountryDTO countryToCountryDTO;
    private final CountryDTOToCountry countryDTOToCountry;

    @Override
    public List<CountryDTO> getCountryList() {
        List<Country> countryList = countryRepository.findAll();
        List<CountryDTO> countryDTOList = new ArrayList<>();
        for (Country e: countryList){
            countryDTOList.add(countryToCountryDTO.convert(e));
        }
        return countryDTOList;
    }

    @Override
    public Country createCountry(CountryDTO countryDTO) {
        return countryRepository.save(countryDTOToCountry.convert(countryDTO));
    }

    @Override
    public boolean deleteCountry(CountryDTO countryDTO) {
        countryRepository.deleteById(countryDTO.getId());
        return true;
    }
}
