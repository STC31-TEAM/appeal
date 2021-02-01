package ru.innopolis.stc31.appeal.utils;

import ru.innopolis.stc31.appeal.model.dto.*;
import ru.innopolis.stc31.appeal.model.entity.*;
import ru.innopolis.stc31.appeal.utils.random.RandomUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * For generation some mock objects
 *
 * @author Sergey Fomin
 */
public class MockUtils {
    /**
     * Single item
     * @return UserDTO instance
     */
    public static UserDTO makeUserDTO() {
        return new UserDTO()
                .setId(RandomUtils.makeId())
                .setBirthday(String.valueOf(LocalDate.now()))
                .setEmail(RandomUtils.makeEmail())
                .setLogin(RandomUtils.makeLogin())
                .setName(RandomUtils.makeName())
                .setSurname(RandomUtils.makeName())
                .setPhone(RandomUtils.getRandomPhone())
                .setStatus((short) RandomUtils.getRandomValue(0, 2));
    }

    /**
     * Single item
     * @return TicketDTO instance
     */
    public static TicketDTO makeTicketDTO() {
        return new TicketDTO();
    }

    /**
     * Single item
     * @return AlbumDTO instance
     */
    public static AlbumDTO makeAlbumDTO() {
        return new AlbumDTO();
    }

    /**
     * Single item
     * @return AlbumDTO instance
     */
    public static CityDTO makeCityDTO() {
        return new CityDTO();
    }

    /**
     * Single item
     * @return CompanyDTO instance
     */
    public static CompanyDTO makeCompanyDTO() {
        return new CompanyDTO()
                .setId(1l)
                .setTitle("SomeCompany")
                .setUserId(1l)
                .setEmail("someEmail@email.com")
                .setCityId(1l)
                .setCountryId(1l)
                .setLogin("SomeLogin")
                .setPassword("SDFLSKDJHFLKDFJHDLDSHFLJFD")
                .setStreetId(1l)
                .setPhone("791111111111");
    }

    /**
     * Single item
     * @return RoleDTO instance
     */
    public static RoleDTO makeRoleDTO() {
        return new RoleDTO()
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
    }

    /**
     * Single item
     * @return ServiceTypeDTO instance
     */
    public static ServiceTypeDTO makeServiceTypeDTO() {
        return new ServiceTypeDTO()
                .setId(RandomUtils.makeId());
    }

    /**
     * Single item
     * @return StreetDTO instance
     */
    public static StreetDTO makeStreetDTO() {
        return new StreetDTO()
                .setId(RandomUtils.makeId())
                .setStreetName(RandomUtils.getRandomStreetName());
    }

    /**
     * Single item
     * @return CountryDTO instance
     */
    public static CountryDTO makeCountryDTO() {
        return new CountryDTO()
                .setId(RandomUtils.makeId())
                .setCountryName(RandomUtils.getRandomCountryName());
    }

    /**
     * Single item (Entity)
     * @return Role instance
     */
    public static Role makeRoleEntity() {
        return new Role()
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
    }

    /**
     * Single item (Entity)
     * @return ServiceType instance
     */
    public static ServiceType makeServiceTypeEntity() {
        return new ServiceType()
                .setId(RandomUtils.makeId());
    }

    /**
     * List items
     * @return List of UserDTO objects
     */
    public static List<UserDTO> makeListUserDTO(int size) {
        return Stream.generate(MockUtils::makeUserDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of TicketDTO objects
     */
    public static List<TicketDTO> makeListTicketDTO(int size) {
        return Stream.generate(MockUtils::makeTicketDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of AlbumDTO objects
     */
    public static List<AlbumDTO> makeListAlbumDTO(int size) {
        return Stream.generate(MockUtils::makeAlbumDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of CityDTO objects
     */
    public static List<CityDTO> makeListCityDTO(int size) {
        return Stream.generate(MockUtils::makeCityDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of CompanyDTO objects
     */
    public static List<CompanyDTO> makeListCompanyDTO(int size) {
        return Stream.generate(MockUtils::makeCompanyDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of RoleDTO objects
     */
    public static List<RoleDTO> makeListRoleDTO(int size) {
        return Stream.generate(MockUtils::makeRoleDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of ServiceTypeDTO objects
     */
    public static List<ServiceTypeDTO> makeListServiceTypeDTO(int size) {
        return Stream.generate(MockUtils::makeServiceTypeDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of CountryDTO objects
     */
    public static List<CountryDTO> makeListCountryDTO(int size) {
        return Stream.generate(MockUtils::makeCountryDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items
     * @return List of CountryDTO objects
     */
    public static List<StreetDTO> makeListStreetDTO(int size) {
        return Stream.generate(MockUtils::makeStreetDTO).limit(size).collect(Collectors.toList());
    }

    /**
     * List items (Entity)
     * @return List of Role objects
     */
    public static List<Role> makeListRoleEntity(int size) {
        return Stream.generate(MockUtils::makeRoleEntity).limit(size).collect(Collectors.toList());
    }

    /**
     * List items (Entity)
     * @return List of ServiceType objects
     */
    public static List<ServiceType> makeServiceTypeEntity(int size) {
        return Stream.generate(MockUtils::makeServiceTypeEntity).limit(size).collect(Collectors.toList());
    }

    /**
     * List items (Entity)
     * @return List of ServiceType objects
     */
    public static City makeCityEntity() {
        return new City()
                .setCityName(RandomUtils.getRandomCityName())
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
    }

    /**
     * List items (Entity)
     * @return List of Street objects
     */
    public static Street makeStreetEntity() {
        return new Street()
                .setStreetName(RandomUtils.getRandomStreetName())
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
    }

    /**
     * List items (Entity)
     * @return List of Country objects
     */
    public static Country makeCountryEntity() {
        return new Country()
                .setCountryName(RandomUtils.getRandomCountryName())
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
    }

    /**
     * List items (Entity)
     * @return List of Country objects
     */
    public static Company makeCompanyEntity() {
        return new Company()
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE))
                .setTitle(RandomUtils.getRandomTitle())
                .setCountryId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE))
                .setUserId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE))
                .setCityId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE))
                .setServiceTypeId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE))
                .setEmail("some@email.ru")
                .setLogin("SomeLogin")
                .setPhone("79122121212");
    }

    /**
     * List items
     * @return List of UserDTO objects
     */
    public static List<Company> makeListCompanyEntity(int size) {
        return Stream.generate(MockUtils::makeCompanyEntity).limit(size).collect(Collectors.toList());
    }

}
