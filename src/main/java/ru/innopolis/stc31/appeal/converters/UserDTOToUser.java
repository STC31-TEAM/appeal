package ru.innopolis.stc31.appeal.converters;

import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;

public class UserDTOToUser {
    public User convert(UserDTO userDTO){
        User user = new User();
        user.setBirthday(userDTO.getBirthday());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        user.setName(userDTO.getUsername());
        user.setCityId(userDTO.getCityId());
        user.setCountryId(userDTO.getCountryId());
        user.setCompanyId(userDTO.getCompanyId());
        user.setStreetId(userDTO.getStreetId());
        user.setMapRoleId(userDTO.getMapRoleId());
        return user;
    }
}
