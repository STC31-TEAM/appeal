package ru.innopolis.stc31.appeal.converters;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;

import java.time.LocalDate;

@Service
public class UserDTOToUser {
    public User convert(UserDTO userDTO) {
        User user = new User();
        user.setBirthday(LocalDate.parse(userDTO.getBirthday()));
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setCityId(userDTO.getCityId());
        user.setCountryId(userDTO.getCountryId());
        user.setCompanyId(userDTO.getCompanyId());
        user.setStreetId(userDTO.getStreetId());
        return user;
    }
}
