package ru.innopolis.stc31.appeal.utils;

import ru.innopolis.stc31.appeal.model.dto.*;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.model.entity.ServiceType;
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
                .setBirthday(LocalDate.now())
                .setEmail(RandomUtils.makeEmail())
                .setLogin(RandomUtils.makeLogin())
                .setUsername(RandomUtils.makeUsername())
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
        return new CompanyDTO();
    }

    /**
     * Single item
     * @return RoleDTO instance
     */
    public static RoleDTO makeRoleDTO() {
        return new RoleDTO();
    }

    /**
     * Single item
     * @return ServiceTypeDTO instance
     */
    public static ServiceTypeDTO makeServiceTypeDTO() {
        return new ServiceTypeDTO();
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
                .setId(RandomUtils.getRandomValue(1, Integer.MAX_VALUE));
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
}
