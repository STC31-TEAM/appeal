package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.UserDTOToUser;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{

    private UserRepository userRepository;
    private UserDTOToUser userDTOToUser;
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> getUserList() {
        return null;
    }

    @Override
    public UserDTO getUserByName(String name) {
        return null;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = userRepository.save(userDTOToUser.convert(userDTO));
        Role role = new Role();
        role.setUserId(user.getId());
        role.setTitle(Roles.USER.toString());
        roleRepository.save(role);
        return userRepository.save(userDTOToUser.convert(userDTO));
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return false;
    }
}
