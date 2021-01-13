package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{
    @Override
    public List<CompanyDTO> getCompanyList() {
        return null;
    }

    @Override
    public boolean createCompany(CompanyDTO companyDTO) {
        return false;
    }

    @Override
    public boolean deleteCompany(CompanyDTO companyDTO) {
        return false;
    }
}
