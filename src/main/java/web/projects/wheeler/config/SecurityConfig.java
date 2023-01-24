package web.projects.wheeler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import web.projects.wheeler.db.auth.RoleType;
import web.projects.wheeler.db.entities.UserModel;
import web.projects.wheeler.service.UserService;

@Configuration
public class SecurityConfig {
    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests(req-> req
                        .requestMatchers("/home", "/login", "/register").permitAll()
                        .requestMatchers("/users/**").hasRole(RoleType.USER.name())
                        .requestMatchers("/admin/**").hasRole(RoleType.ADMIN.name())
                        .anyRequest().authenticated())
                .httpBasic();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        return username -> {
            UserModel user= userService.getUserByUsername(username);
            return new User(user.getUsername(),
                    user.getPassword(), true, true, true, true,
                    user.getAuthorities().stream().map(a->new SimpleGrantedAuthority("ROLE_"+a.getRole().name())).toList());
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService());

        return provider;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

