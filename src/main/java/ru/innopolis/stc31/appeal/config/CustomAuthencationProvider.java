package ru.innopolis.stc31.appeal.config;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.model.entity.Role;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class CustomAuthencationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        ru.innopolis.stc31.appeal.model.entity.User user = userRepository.findByLogin(login);
        if(user == null){
            throw new BadCredentialsException("Неизвестный логин пользователя: " + login);
        }
        if(!password.equals(user.getPassword())){
            throw new BadCredentialsException(("Неверный пароль"));
        }
        List<String> roles = new ArrayList<>();
        roleRepository.findByUserId(user.getId()).stream().forEach(role -> roles.add(role.getTitle()));

        UserDetails principal = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(roles.stream().toArray(String[]::new))
                .build();

        return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
