package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.model.SuccessModel;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.services.CompanyService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Testing CompanyController
 */
@SpringJUnitConfig
class CompanyControllerTest {

    @InjectMocks
    private CompanyController controller;
    @Spy
    private CompanyDTOToCompany companyDTOToCompany;

    @Spy
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Spy
    private CompanyService companyService;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> controller.getAllCompanies());
    }

    @Test
    void getAllCompaniesWithOk() {
        List<CompanyDTO> companies = MockUtils.makeListCompanyDTO(5);
        when(companyService.getCompanyList()).thenReturn(companies);

        assertEquals(companies.size(), controller.getAllCompanies().size());
    }

    @Test
    void createCompanyWithOk() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        Company company = companyDTOToCompany.convert(companyDTO);
        when(companyService.createCompany(companyDTO)).thenReturn(company);

        ResponseEntity<CompanyDTO> responseEntity = controller.createCompany(companyDTO);

        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertEquals(responseEntity.getBody().getServiceTypeId(), companyDTO.getServiceTypeId());
        assertEquals(responseEntity.getBody().getLogin(), companyDTO.getLogin());
        assertEquals(responseEntity.getBody().getPassword(), companyDTO.getPassword());
        assertEquals(responseEntity.getBody().getPhone(), companyDTO.getPhone());
        assertEquals(responseEntity.getBody().getStatus(), companyDTO.getStatus());
    }

    @Test
    void createCompanyWithFail() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();

        when(companyService.createCompany(companyDTO)).thenReturn(null);

        ResponseEntity<CompanyDTO> responseEntity = controller.createCompany(companyDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }

    @Test
    void deleteCompanyWithOk() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();

        SuccessModel successModel = new SuccessModel().setResult("OK");
        when(companyService.deleteCompany(companyDTO)).thenReturn(true);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteCompany(companyDTO);

        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
        assertEquals(successModel.getResult(), responseEntity.getBody().getResult());
    }

    @Test
    void deleteCompanyWithFail() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();

        when(companyService.deleteCompany(companyDTO)).thenReturn(false);

        ResponseEntity<SuccessModel> responseEntity = controller.deleteCompany(companyDTO);

        assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
    }

    @Test
    void getCompanyByCountry() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        companyDTO.setCountryId(countryDTO.getId());
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        companyDTOList.add(companyDTO);
        doReturn(companyDTOList).when(companyService).getCompanyListByCountry(countryDTO);

        assertEquals(companyDTOList.size(),
                controller.getCompanyByCountry(countryDTO).size());
    }

    @Test
    void getCompaniesSortedByCompletedTickets() {
        List<CompanyDTO> companyDTOList = MockUtils.makeListCompanyDTO(3);
        doReturn(companyDTOList).when(companyService).getCompaniesSortedByCompletedTickets();

        assertEquals(companyDTOList.size(),
                controller.getCompaniesSortedByCompletedTickets().size());
    }
}
