package ru.innopolis.stc31.appeal.converters;

import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.User;

public class UserToUserDTO {

    public UserDTO convert(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getName());
        userDTO.setLogin(user.getLogin());
        userDTO.setPhone(user.getPhone());
        userDTO.setStatus(user.getStatus());
        return userDTO;
    }

}
