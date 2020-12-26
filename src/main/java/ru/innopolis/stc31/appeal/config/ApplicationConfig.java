package ru.innopolis.stc31.appeal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.innopolis.stc31.appeal.model.UserModel;
import ru.innopolis.stc31.appeal.model.dto.*;
import ru.innopolis.stc31.appeal.services.*;

import java.util.List;

/**
 * @author Sergey Fomin
 */
@Configuration
@EnableTransactionManagement
public class ApplicationConfig {
    @Bean
    public AlbumService albumService() {
        return new AlbumService() {
            @Override
            public List<AlbumDTO> getAlbumList() {
                return null;
            }

            @Override
            public boolean createAlbum(AlbumDTO albumDTO) {
                return false;
            }

            @Override
            public boolean deleteAlbum(AlbumDTO albumDTO) {
                return false;
            }
        };
    }

    @Bean
    public CityService cityService() {
        return new CityService() {
            @Override
            public List<CityDTO> getCityList() {
                return null;
            }

            @Override
            public boolean createCity(CityDTO cityDTO) {
                return false;
            }

            @Override
            public boolean deleteCity(CityDTO cityDTO) {
                return false;
            }
        };
    }

    @Bean
    public CompanyService companyService() {
        return new CompanyService() {
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
        };
    }

    @Bean
    public CountryService countryService() {
        return new CountryService() {
            @Override
            public List<CountryDTO> getCountyList() {
                return null;
            }

            @Override
            public boolean createCounty(CountryDTO countryDTO) {
                return false;
            }

            @Override
            public boolean deleteCounty(CountryDTO countryDTO) {
                return false;
            }
        };
    }

    @Bean
    public RoleService roleService() {
        return new RoleService() {
            @Override
            public List<RoleDTO> getRoleList() {
                return null;
            }

            @Override
            public boolean createRole(RoleDTO roleDTO) {
                return false;
            }

            @Override
            public boolean deleteRole(RoleDTO roleDTO) {
                return false;
            }
        };
    }

    @Bean
    public StreetService streetService() {
        return new StreetService() {
            @Override
            public List<StreetDTO> getStreetList() {
                return null;
            }

            @Override
            public boolean createStreet(StreetDTO streetDTO) {
                return false;
            }

            @Override
            public boolean deleteStreet(StreetDTO streetDTO) {
                return false;
            }
        };
    }

    @Bean
    public TicketService ticketService() {
        return new TicketService() {
            @Override
            public List<TicketDTO> getTicketList() {
                return null;
            }

            @Override
            public boolean createTicket(TicketDTO ticketDTO) {
                return false;
            }

            @Override
            public boolean deleteTicket(TicketDTO ticketDTO) {
                return false;
            }
        };
    }

    @Bean
    public TypeOfServicesService typeOfServicesService() {
        return new TypeOfServicesService() {
            @Override
            public List<TypeOfServiceDTO> getTypeOfServiceList() {
                return null;
            }

            @Override
            public boolean createTypeOfService(TypeOfServiceDTO typeOfServiceDTO) {
                return false;
            }

            @Override
            public boolean deleteTypeOfService(TypeOfServiceDTO typeOfServiceDTO) {
                return false;
            }
        };
    }

    @Bean
    public UsersService usersService() {
        return new UsersService() {
            @Override
            public List<UserDTO> getUserList() {
                return null;
            }

            @Override
            public UserModel getUserByName(String name) {
                return null;
            }

            @Override
            public boolean createUser(UserDTO userDTO) {
                return false;
            }

            @Override
            public boolean deleteUser(UserDTO userDTO) {
                return false;
            }
        };
    }
}
