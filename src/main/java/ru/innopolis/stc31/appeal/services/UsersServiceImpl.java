package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.converters.UserDTOToUser;
import ru.innopolis.stc31.appeal.converters.UserToUserDTO;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.exceptions.UsersErrors;
import ru.innopolis.stc31.appeal.model.dto.UserDTO;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.model.entity.User;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{

    private UserRepository userRepository;
    private UserDTOToUser userDTOToUser;
    private UserToUserDTO userToUserDTO;
    private RoleRepository roleRepository;

    @Override
    public List<UserDTO> getUserList() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(userToUserDTO.convert(user));
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserByName(String name) {
        return null;
    }

    @Override
    public User createUser(UserDTO userDTO) throws UsersErrors {
        User user = userDTOToUser.convert(userDTO);
        user.setStatus((short) 0);
        Role role = roleRepository.findByTitle(Roles.USER.toString());
        user.setRoleId(role.getId());

        if (role.getId() == 0 ){
            ErrorMessage errorMessage = new ErrorMessage(-1, "Не удалось установить роль( "+ role.getTitle() + ") для пользователя: " + user.toString());
            log.error(errorMessage.toString());
            throw new UsersErrors(errorMessage);
        }


        return userRepository.save(user);
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) {
        return false;
    }
}
