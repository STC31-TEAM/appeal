package ru.innopolis.stc31.appeal.config;


import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import ru.innopolis.stc31.appeal.services.Roles;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
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
                .antMatchers("/api/v1.0/user/**").hasAnyRole(Roles.USER.toString(), Roles.ADMIN.toString())
                .antMatchers("/admin/**").hasRole(Roles.ADMIN.toString())
                .antMatchers("/moderator/**").hasRole(Roles.MODERATOR.toString())
                .antMatchers("/swagger-ui.html").hasRole(Roles.ADMIN.toString())
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

}
