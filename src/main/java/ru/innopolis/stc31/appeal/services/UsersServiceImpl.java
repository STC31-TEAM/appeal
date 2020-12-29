package ru.innopolis.stc31.appeal.services;

import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.UserModel;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService{
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
}
