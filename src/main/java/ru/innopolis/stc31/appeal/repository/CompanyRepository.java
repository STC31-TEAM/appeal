package ru.innopolis.stc31.appeal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.innopolis.stc31.appeal.model.entity.Company;

import java.util.List;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {
    List<Company> findCompaniesByCountryId(long countryId);

    @Query(value = "SELECT * FROM companies "
            + "WHERE id IN (SELECT id_company FROM tickets "
            + "WHERE id_company IS NOT NULL AND close_date IS NOT NULL "
            + "GROUP BY id_company "
            + "ORDER BY COUNT(id_company) desc)", nativeQuery = true)
    List<Company> companiesSortedByCompletedTickets();
}
