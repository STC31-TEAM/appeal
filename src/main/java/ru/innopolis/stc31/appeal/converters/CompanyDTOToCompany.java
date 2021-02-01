package ru.innopolis.stc31.appeal.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;

@Component
public class CompanyDTOToCompany implements Converter<CompanyDTO, Company> {

    @Override
    public Company convert(CompanyDTO source) {
        Company company = new Company();
        company.setUserId(source.getUserId());
        company.setServiceTypeId(source.getServiceTypeId());
        company.setCountryId(source.getCountryId());
        company.setCityId(source.getCityId());
        company.setStreetId(source.getStreetId());
        company.setLogin(source.getLogin());
        company.setPassword(source.getPassword());
        company.setEmail(source.getEmail());
        company.setPhone(source.getPhone());
        company.setTitle(source.getTitle());
        company.setStatus(source.getStatus());
        return company;
    }
}
