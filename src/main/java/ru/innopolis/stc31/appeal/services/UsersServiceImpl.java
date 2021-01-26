package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.innopolis.stc31.appeal.config.AppealPasswordEncoder;
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
@Service
public class UsersServiceImpl implements UsersService{

    @Value("${config.security.secret}")
    private String secret;

    private UserRepository userRepository;
    private UserDTOToUser userDTOToUser;
    private UserToUserDTO userToUserDTO;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(UserRepository userRepository,
                            UserDTOToUser userDTOToUser,
                            UserToUserDTO userToUserDTO,
                            RoleRepository roleRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userDTOToUser = userDTOToUser;
        this.userToUserDTO = userToUserDTO;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

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
        user.setPassword(passwordEncoder.encode(user.getPassword()+secret));

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
