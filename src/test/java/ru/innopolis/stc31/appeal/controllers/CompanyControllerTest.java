package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.services.CompanyService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Testing CompanyController
 */
@SpringJUnitConfig
class CompanyControllerTest {

    @InjectMocks
    private CompanyController controller;

    @Mock
    private CompanyService service;

    @Spy
    private CompanyDTOToCompany companyDTOToCompany;

    @Spy
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllCompanies());
        assertDoesNotThrow(() -> controller.createCompany(MockUtils.makeCompanyDTO()));
    }

    @Test
    void getAllCompaniesWithOk() {
        List<CompanyDTO> companies = MockUtils.makeListCompanyDTO(5);
        when(service.getCompanyList()).thenReturn(companies);

        assertEquals(companies.size(), controller.getAllCompanies().size());
    }

    @Test
    void createCompany() {
        CompanyDTO companyDTO = new CompanyDTO(1, 4, 2, 8, 3,
                "TestLogin", "TestPassword", "mail@gmail.com",
                84728568747L, "Company Tilte", (short) 2);
        Company company = companyDTOToCompany.convert(companyDTO);
        when(service.createCompany(companyDTO)).thenReturn(company);

        ResponseEntity<CompanyDTO> responseEntity = controller.createCompany(companyDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getServiceTypeId(), companyDTO.getServiceTypeId());
        assertEquals(responseEntity.getBody().getLogin(), companyDTO.getLogin());
        assertEquals(responseEntity.getBody().getPassword(), companyDTO.getPassword());
        assertEquals(responseEntity.getBody().getPhone(), companyDTO.getPhone());
        assertEquals(responseEntity.getBody().getStatus(), companyDTO.getStatus());
    }

    @Test
    void deleteCompany() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(service.deleteCompany(companyDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteCompany(companyDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getResult(), successModel.getResult());
    }
}
