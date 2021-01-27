package ru.innopolis.stc31.appeal.converters;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class CompanyDTOToCompanyTest {

    @InjectMocks
    private CompanyDTOToCompany companyDTOToCompany;

    @Test
    void convert() {
        CompanyDTO companyDTO = new CompanyDTO(3l, 4l, 2l, 1l, 2l, 4l,
                "Test Company", "pass22", "company_test@mail.ru",
                84012587315L, "Company of Australia", (short)1, "Full address");

        assertEquals(companyDTOToCompany.convert(companyDTO).getUserId(), companyDTO.getUserId());
        assertEquals(companyDTOToCompany.convert(companyDTO).getServiceTypeId(), companyDTO.getServiceTypeId());
        assertEquals(companyDTOToCompany.convert(companyDTO).getCountryId(), companyDTO.getCountryId());
        assertEquals(companyDTOToCompany.convert(companyDTO).getCityId(), companyDTO.getCityId());
        assertEquals(companyDTOToCompany.convert(companyDTO).getStreetId(), companyDTO.getStreetId());
        assertEquals(companyDTOToCompany.convert(companyDTO).getLogin(), companyDTO.getLogin());
        assertEquals(companyDTOToCompany.convert(companyDTO).getPassword(), companyDTO.getPassword());
        assertEquals(companyDTOToCompany.convert(companyDTO).getEmail(), companyDTO.getEmail());
        assertEquals(companyDTOToCompany.convert(companyDTO).getPhone(), companyDTO.getPhone());
        assertEquals(companyDTOToCompany.convert(companyDTO).getTitle(), companyDTO.getTitle());
        assertEquals(companyDTOToCompany.convert(companyDTO).getStatus(), companyDTO.getStatus());
    }
}