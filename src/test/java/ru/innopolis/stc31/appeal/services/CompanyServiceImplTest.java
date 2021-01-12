package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Testing CompanyServiceImpl
 */
@SpringJUnitConfig
class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl service;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> service.deleteCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> service.getCompanyList());
    }
}
