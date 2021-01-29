package ru.innopolis.stc31.appeal.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.innopolis.stc31.appeal.exceptions.ErrorMessage;
import ru.innopolis.stc31.appeal.exceptions.RoleErrors;
import ru.innopolis.stc31.appeal.repository.RoleRepository;
import ru.innopolis.stc31.appeal.repository.UserRepository;

import java.util.Locale;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${config.security.secret}")
    private String secret;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(UserRepository userRepository,
                                        RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String login = authentication.getName();
        String password = passwordEncoder.encode(authentication.getCredentials().toString()).toLowerCase(Locale.ROOT);

        ru.innopolis.stc31.appeal.model.entity.User user = userRepository.findByLogin(login);
        if (user == null) {
            throw new BadCredentialsException("Неизвестный логин пользователя: " + login);
        }
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException(("Неверный пароль"));
        }

        String role = roleRepository.findById(user.getRoleId()).getTitle();

        if (role == null) {
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
