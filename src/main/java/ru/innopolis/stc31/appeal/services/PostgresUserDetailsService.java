package ru.innopolis.stc31.appeal.services;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

@AllArgsConstructor
@Component
public class PostgresUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        ru.innopolis.stc31.appeal.model.entity.User userEntity = userRepository.findByLogin(login);

        if(userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDetails user = User.builder()
                .username(userEntity.getLogin())
                .password(userEntity.getPassword())
                .roles(roleRepository.findByUserId(userEntity.getId()).toString())
                .build();

        return user;

    }
}
