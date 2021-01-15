package ru.innopolis.stc31.appeal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.services.CompanyService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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

    /*@Test
    void createCompanyWithOk() {
        CompanyDTO company = MockUtils.makeCompanyDTO();

        when(service.createCompany(company)).thenReturn(true);

        assertTrue(controller.createCompany(company));
    }*/
}
