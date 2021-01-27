package ru.innopolis.stc31.appeal.converters;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;

@Service
public class UserToUserDTO {

    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setBirthday(String.valueOf(user.getBirthday()));
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setStatus(user.getStatus());
        userDTO.setCompanyId(user.getCompanyId());
        userDTO.setCountryId(user.getCountryId());
        userDTO.setCityId(user.getCityId());
        userDTO.setStreetId(user.getStreetId());
        return userDTO;
    }

}
