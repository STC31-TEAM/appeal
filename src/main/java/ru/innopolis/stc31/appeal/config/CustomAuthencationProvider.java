package ru.innopolis.stc31.appeal.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.exceptions.RoleErrors;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

@AllArgsConstructor
@Component
public class CustomAuthencationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @SneakyThrows
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

        String role = roleRepository.findById(user.getRoleId()).getTitle();

        if(role == null){
            ErrorMessage errorMessage = new ErrorMessage(-2, "Для пользователя: " + login + " не удалось определить роль");
            throw new RoleErrors(errorMessage);
        }

        UserDetails principal = User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(role)
                .build();

        return new UsernamePasswordAuthenticationToken(principal, password, principal.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
