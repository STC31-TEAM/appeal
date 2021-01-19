package ru.innopolis.stc31.appeal.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthencationProvider customAuthencationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthencationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .requireCsrfProtectionMatcher(new RequestMatcher() {
                    private final Pattern allowedMethods = Pattern.compile("^(GET|POST|PUT|DELETE)$");

                    /**
                     * Allow REST methods
                     *
                     * @param request HttpServletRequest
                     * @return false if permit and true if deny
                     */
                    @Override
                    public boolean matches(HttpServletRequest request) {
                        return !allowedMethods.matcher(request.getMethod()).matches();
                    }
                })
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1.0/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

}
