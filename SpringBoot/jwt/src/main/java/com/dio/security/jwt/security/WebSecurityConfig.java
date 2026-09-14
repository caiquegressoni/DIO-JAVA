package com.dio.security.jwt.security;


import jakarta.servlet.Servlet;
import org.apache.catalina.servlets.WebdavServlet;
import org.h2.server.web.WebServer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import jakarta.servlet.annotation.WebServlet;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@WebServlet("/h2/console/**")
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private static final String[] SWAGGER_EXTENSIONS = {
            "/v2/api/docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .headers(headers -> headers
                        .defaultsDisabled()
                        .cacheControl(withDefaults())
                        .frameOptions(withDefaults())
                )

                .cors(withDefaults())

                .csrf(AbstractHttpConfigurer::disable)

                .addFilterAfter(
                        new JWTFilter(),
                        UsernamePasswordAuthenticationFilter.class
                )

                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(SWAGGER_EXTENSIONS).permitAll()
                        .requestMatchers("/h2/console/**").permitAll()

                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()

                        .requestMatchers(HttpMethod.GET, "/users")
                        .hasAnyRole("USERS", "MANAGERS")

                        .requestMatchers("/manager")
                        .hasRole("MANAGERS")

                        .anyRequest()
                        .authenticated()
                )

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        return http.build();
    }

    @Bean
    public ServletRegistrationBean<Servlet> h2servletRegistration(){
        ServletRegistrationBean<Servlet> registration = new ServletRegistrationBean<>(new WebdavServlet());
        registration.addUrlMappings("/h2/console/*");
        return registration;
    }
}







/*First Method
              .authorizeHttpRequests(h -> h
        .requestMatchers(SWAGGER_EXTENSIONS).permitAll())
        .authorizeHttpRequests(h -> h
        .requestMatchers("/h2/console/**").permitAll())
        .authorizeHttpRequests(h -> h
        .requestMatchers(HttpMethod.POST, "/login").permitAll())
        .authorizeHttpRequests(h -> h
        .requestMatchers(HttpMethod.POST, "/users").permitAll())
        .authorizeHttpRequests(h -> h
        .requestMatchers(HttpMethod.GET, "/users").hasAnyRole("USERS", "MANAGERS"))
        .authorizeHttpRequests(h -> h
        .requestMatchers("/managers").hasRole("MANAGERS")
                        .anyRequest().authenticated())
        .sessionManagement(s -> s
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
* */