package ru.innopolis.stc31.appeal.controllers.ui;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.ui.Model;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.services.CompanyService;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class CompanyUiControllerTest {

    @InjectMocks
    private CompanyUiController companyUiController;

    @Mock
    private CompanyService service;

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
    void createCompany() {
        CompanyDTO companyDTO = new CompanyDTO(1l, 3l, 4l, 2l, 8l, 3l,
                "TestLogin", "TestPassword", "mail@gmail.com",
                84728568747L, "Company Tilte", (short) 2, "Full address");
        Company company = companyDTOToCompany.convert(companyDTO);
        when(service.createCompany(companyDTO)).thenReturn(company);

        String view = companyUiController.createCompany(companyDTO, model);

        assertNotNull(view);
    }
}