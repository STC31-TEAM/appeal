package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.entity.Company;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class CompanyToCompanyDTOTest {

    @InjectMocks
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Test
    void convert() {
       Company company = new Company(5, 2, 3, 2, 1, 4, "Company test", "password123", "test@gmail.com", "84012379156", "British Company", (short)1);

        assertEquals(companyToCompanyDTO.convert(company).getUserId(), company.getUserId());
        assertEquals(companyToCompanyDTO.convert(company).getServiceTypeId(), company.getServiceTypeId());
        assertEquals(companyToCompanyDTO.convert(company).getCountryId(), company.getCountryId());
        assertEquals(companyToCompanyDTO.convert(company).getCityId(), company.getCityId());
        assertEquals(companyToCompanyDTO.convert(company).getStreetId(), company.getStreetId());
        assertEquals(companyToCompanyDTO.convert(company).getLogin(), company.getLogin());
        assertEquals(companyToCompanyDTO.convert(company).getPassword(), company.getPassword());
        assertEquals(companyToCompanyDTO.convert(company).getEmail(), company.getEmail());
        assertEquals(companyToCompanyDTO.convert(company).getPhone(), company.getPhone());
        assertEquals(companyToCompanyDTO.convert(company).getTitle(), company.getTitle());
        assertEquals(companyToCompanyDTO.convert(company).getStatus(), company.getStatus());
    }
}