package Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
                    .authorizeHttpRequests(auth->{
                        auth.requestMatchers("/home").permitAll();
                        auth.requestMatchers("/admin").hasRole("ADMIN");
                        auth.requestMatchers("/users").hasRole("USER");
                        auth.anyRequest().authenticated();
                    })
                    .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                    .build();
    }
    @Bean
    public UserDetailsService userDetailsSercice(){
        UserDetails normalUser = User.builder()
        .username("mafu")
        .password("$2a$12$fBGgqWFECCI7XkGUEWgJsu9fa5S5xdHb2w4uyXXFlTT1rmwheBx/2")
        .roles("USER")
        .build();

        UserDetails adminUser = User.builder()
        .username("mafu")
        .password("$2a$12$RKfH7zmGPddDyZwzv71W2ex5pjwuhrB.4KKTUITzRjIhACmNnkswW")
        .roles("ADMIN", "USER")
        .build();
        return null;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    }

