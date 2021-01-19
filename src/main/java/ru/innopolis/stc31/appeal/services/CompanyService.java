package ru.innopolis.stc31.appeal.services;

import ru.innopolis.stc31.appeal.model.dto.CompanyDTO;
import ru.innopolis.stc31.appeal.model.dto.CountryDTO;
import ru.innopolis.stc31.appeal.model.entity.Company;

import java.util.List;

/**
 * interface for Company services
 *
 * @author v.shulepov
 */
public interface CompanyService {
    /**
     * return list of all companies
     * @return list of companies
     */
    List<CompanyDTO> getCompanyList();

    /**
     * create new company
     * @param companyDTO company
     * @return result of operation
     */
    Company createCompany(CompanyDTO companyDTO);

    /**
     * delete company from base
     * @param companyDTO company needed to remove
     * @return result of operation
     */
    boolean deleteCompany(CompanyDTO companyDTO);

    /**
     * return list of all company in select country
     * @param countryDTO needed country
     * @return list of companies in select country
     */
    List<CompanyDTO> getCompanyListByCountry(CountryDTO countryDTO);

    /**
     * return list of companies has completed tickets sort by count of tickets
     * @return List of company
     */
    List<CompanyDTO> getCompaniesSortedByCompletedTickets();
}
