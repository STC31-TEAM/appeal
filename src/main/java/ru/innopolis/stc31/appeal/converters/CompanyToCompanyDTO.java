package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;

@Component
public class CompanyToCompanyDTO implements Converter<Company, CompanyDTO> {

    @Override
    public CompanyDTO convert(Company source) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setServiceTypeId(source.getServiceTypeId());
        companyDTO.setCountryId(source.getCountryId());
        companyDTO.setCityId(source.getCityId());
        companyDTO.setStreetId(source.getStreetId());
        companyDTO.setLogin(source.getLogin());
        companyDTO.setPassword(source.getPassword());
        companyDTO.setEmail(source.getEmail());
        companyDTO.setPhone(source.getPhone());
        companyDTO.setTitle(source.getTitle());
        companyDTO.setStatus(source.getStatus());
        return companyDTO;
    }
}
