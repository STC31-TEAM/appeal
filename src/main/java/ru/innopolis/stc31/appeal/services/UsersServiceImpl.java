package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{

    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUserList() {
        return null;
    }

    @Override
    public UserDTO getUserByName(String name) {
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
