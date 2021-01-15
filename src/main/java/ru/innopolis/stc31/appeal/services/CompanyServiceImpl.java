package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.CompanyDTOToCompany;
import ru.innopolis.stc31.appeal.converters.CompanyToCompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;
import ru.innopolis.stc31.appeal.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CompanyDTOToCompany companyDTOToCompany;
    private final CompanyToCompanyDTO companyToCompanyDTO;

    @Override
    public List<CompanyDTO> getCompanyList() {
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDTO> companyDTOList = new ArrayList<>();
        for (Company company : companyList) {
            companyDTOList.add(companyToCompanyDTO.convert(company));
        }
        return companyDTOList;
    }

    @Override
    public Company createCompany(CompanyDTO companyDTO) {
        return companyRepository.save(companyDTOToCompany.convert(companyDTO));
    }

    @Override
    public boolean deleteCompany(CompanyDTO companyDTO) {
        return true;
    }
}
