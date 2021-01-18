package ru.innopolis.stc31.appeal.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.AlbumDTO;
import ru.innopolis.stc31.appeal.model.dto.CityDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.AlbumLink;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.repository.CompanyRepository;
import ru.innopolis.stc31.appeal.utils.MockUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.shortThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Testing CompanyServiceImpl
 */
@SpringJUnitConfig
class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl service;

    @Mock
    private CompanyRepository companyRepository;

    @Spy
    private CompanyDTOToCompany companyDTOToCompany;

    @Spy
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> service.createCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> service.deleteCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> service.getCompanyList());
    }

    @Test
    void getCompanyList() {
        List<Company> companyList = new ArrayList<>();
        for (int count = 1; count < 6; count++){
            companyList.add(new Company(count, count * 3, count * 4, count * 2, count * 8, count * 3,
                    "TestLogin" + count, "TestPassword" + count, "mail" + count +"@gmail.com",
                    84728 + count * 11, "Company" + count + " Tilte", (short) 2));
        }
        when(companyRepository.findAll()).thenReturn(companyList);

        List<CompanyDTO> companyDTOList = service.getCompanyList();

        assertEquals(companyList.size(), companyDTOList.size());
        assertEquals(companyList.get(1).getServiceTypeId(), companyDTOList.get(1).getServiceTypeId());
        assertEquals(companyList.get(1).getLogin(), companyDTOList.get(1).getLogin());
        assertEquals(companyList.get(1).getPassword(), companyDTOList.get(1).getPassword());
        assertEquals(companyList.get(1).getPhone(), companyDTOList.get(1).getPhone());
    }

    @Test
    void createCompany() {
        CompanyDTO companyDTO = new CompanyDTO(1, 3, 4, 2, 8, 3,
                "TestLogin", "TestPassword", "mail@gmail.com",
                84728568747L, "Company Tilte", (short) 2);
        Company company = companyDTOToCompany.convert(companyDTO);
        when(companyRepository.save(company)).thenReturn(company);

        assertEquals(service.createCompany(companyDTO).getServiceTypeId(), companyDTO.getServiceTypeId());
        assertEquals(service.createCompany(companyDTO).getLogin(), companyDTO.getLogin());
        assertEquals(service.createCompany(companyDTO).getPassword(), companyDTO.getPassword());
        assertEquals(service.createCompany(companyDTO).getPhone(), companyDTO.getPhone());
        assertEquals(service.createCompany(companyDTO).getStatus(), companyDTO.getStatus());
    }

    @Test
    void deleteCompany() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        assertEquals(service.deleteCompany(companyDTO), true);
        verify(companyRepository).deleteById(any());
    }
}
