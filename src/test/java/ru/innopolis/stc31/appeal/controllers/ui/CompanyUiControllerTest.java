package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.exceptions.CompanyErrors;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.services.CompanyService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class CompanyUiControllerTest {

    @InjectMocks
    private CompanyUiController companyUiController;

    @Spy
    private CompanyService companyService;

    @Spy
    private CompanyDTOToCompany companyDTOToCompany;

    @Spy
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Mock
    private Model model;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> companyUiController.createCompany(MockUtils.makeCompanyDTO(),model));
    }

    @Test
    void createCompanyWithOk() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        Company company = companyDTOToCompany.convert(companyDTO);
        when(companyService.createCompany(companyDTO)).thenReturn(company);

        String view = companyUiController.createCompany(companyDTO, model);

        assertNotNull(view);
        assertTrue(view.contains("success"));
    }

    @Test
    void createCompanyWithFail() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        when(companyService.createCompany(companyDTO)).thenReturn(null);
//        doReturn(null).when(companyService).createCompany(companyDTO);

        String view = companyUiController.createCompany(companyDTO, model);

        assertNotNull(view);
        assertTrue(view.contains("fail"));
    }
}