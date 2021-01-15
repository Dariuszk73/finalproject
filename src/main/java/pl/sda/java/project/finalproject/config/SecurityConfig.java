package pl.sda.java.project.finalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/add/event").hasAnyAuthority("COMMON_USER", "ORGANISER")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login-submit-data")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout-user", "GET"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT u.email, u.password, 1 " +
                        "FROM users u WHERE u.email = ?")
                .authoritiesByUsernameQuery("SELECT u.email, r.role_name " +
                        "FROM users u " +
                        "JOIN users_roles ur ON u.id = ur.user_entity_id " +
                        "JOIN roles r ON ur.roles_id = r.id " +
                        "WHERE u.email = ?")
                .passwordEncoder(passwordEncoder);
    }
}
