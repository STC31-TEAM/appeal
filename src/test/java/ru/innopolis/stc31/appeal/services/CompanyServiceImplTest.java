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
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
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
import static org.mockito.Mockito.*;

/**
 * Testing CompanyServiceImpl
 */
@SpringJUnitConfig
class CompanyServiceImplTest {

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Spy
    private CompanyDTOToCompany companyDTOToCompany;

    @Spy
    private CompanyToCompanyDTO companyToCompanyDTO;

    @Test
    void checkOnOk() {
        assertDoesNotThrow(() -> companyService.createCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> companyService.deleteCompany(MockUtils.makeCompanyDTO()));
        assertDoesNotThrow(() -> companyService.getCompanyList());
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

        List<CompanyDTO> companyDTOList = companyService.getCompanyList();

        assertEquals(companyList.size(), companyDTOList.size());
        assertEquals(companyList.get(1).getServiceTypeId(), companyDTOList.get(1).getServiceTypeId());
        assertEquals(companyList.get(1).getLogin(), companyDTOList.get(1).getLogin());
        assertEquals(companyList.get(1).getPassword(), companyDTOList.get(1).getPassword());
        assertEquals(companyList.get(1).getPhone(), companyDTOList.get(1).getPhone());
    }

    @Test
    void createCompany() {
        CompanyDTO companyDTO = new CompanyDTO(1l, 3l, 4l, 2l, 8l, 3l,
                "TestLogin", "TestPassword", "mail@gmail.com",
                84728568747L, "Company Tilte", (short) 2, "Full address");
        Company company = companyDTOToCompany.convert(companyDTO);
        when(companyRepository.save(company)).thenReturn(company);

        assertEquals(companyService.createCompany(companyDTO).getServiceTypeId(), companyDTO.getServiceTypeId());
        assertEquals(companyService.createCompany(companyDTO).getLogin(), companyDTO.getLogin());
        assertEquals(companyService.createCompany(companyDTO).getPassword(), companyDTO.getPassword());
        assertEquals(companyService.createCompany(companyDTO).getPhone(), companyDTO.getPhone());
        assertEquals(companyService.createCompany(companyDTO).getStatus(), companyDTO.getStatus());
    }

    @Test
    void deleteCompany() {
        CompanyDTO companyDTO = MockUtils.makeCompanyDTO();
        assertEquals(companyService.deleteCompany(companyDTO), true);
        verify(companyRepository).deleteById(any());
    }

    @Test
    void getCompanyListByCountry() {
        CountryDTO countryDTO = MockUtils.makeCountryDTO();
        List<Company> companyList = MockUtils.makeListCompanyEntity(1);
        companyList.get(0).setCountryId(countryDTO.getId());
        doReturn(companyList).when(companyRepository).findCompaniesByCountryId(countryDTO.getId());

        assertEquals(companyList.size(),
                companyService.getCompanyListByCountry(countryDTO).size());
    }

    @Test
    void getCompaniesSortedByCompletedTickets() {
        List<Company> companyList = MockUtils.makeListCompanyEntity(3);
        doReturn(companyList).when(companyRepository).companiesSortedByCompletedTickets();

        assertEquals(companyList.size(),
                companyService.getCompaniesSortedByCompletedTickets().size());
    }
}
