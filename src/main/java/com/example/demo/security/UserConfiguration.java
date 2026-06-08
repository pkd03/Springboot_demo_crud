package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserConfiguration {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}admin")
                .roles("admin")
                .build();

        UserDetails client = User
                .withUsername("client")
                .password("{noop}client")
                .roles("client")
                .build();
        return new InMemoryUserDetailsManager(admin, client);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
            http.authorizeHttpRequests(
                    configurer->configurer
                            .requestMatchers(HttpMethod.GET, "/api/products").hasAnyRole("admin", "client")
                            .requestMatchers(HttpMethod.GET, "/api/products/**").hasAnyRole("admin", "client")
                            .requestMatchers(HttpMethod.POST, "/api/products").hasAnyRole("admin")
                            .requestMatchers(HttpMethod.PUT, "/api/products").hasAnyRole( "admin")
                            .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("admin")
            );

            http.httpBasic(Customizer.withDefaults());

            http.csrf(csrf->csrf.disable());
            // csrf - cross site request forgery

            return http.build();
    }
}
