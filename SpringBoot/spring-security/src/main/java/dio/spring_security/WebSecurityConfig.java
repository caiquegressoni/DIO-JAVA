package dio.spring_security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true)
public class WebSecurityConfig {
    /*
    * Na versão atual utilizamos o UserDetaisl e as anotações acima,
    * para fazer um usuario em memoria
    * */

    @Bean
    public UserDetailsService users() {

        UserDetails user = User
                .withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}master123")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/managers/**").hasRole("MANAGER")
                        .requestMatchers("/users/**").hasAnyRole("USER", "MANAGER")
                        .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
        return http.build();
    }

}
