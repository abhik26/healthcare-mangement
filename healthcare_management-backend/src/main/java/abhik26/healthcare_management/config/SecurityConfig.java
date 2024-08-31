package abhik26.healthcare_management.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import abhik26.healthcare_management.entity.enums.UserAuthority;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Value("${spring.data.rest.base-path}")
    private String restBasePath;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers(restBasePath + "/patients/**").hasAuthority(UserAuthority.PATIENT.toString())
                .antMatchers(restBasePath + "/doctors/**").hasAuthority(UserAuthority.DOCTOR.toString())
                .anyRequest().permitAll().and()
                .httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

        // prevents forbidden error for POST apis
        http.csrf(csrf -> csrf.disable());
        // http.cors(cors -> cors.disable());
    }

}
