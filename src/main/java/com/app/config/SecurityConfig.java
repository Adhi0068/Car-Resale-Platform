package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
// This will run automatically first before all the code
//because this will tell which url the user can access before login and after login
public class SecurityConfig {

    private JWTFilter jwtFilter;

    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http //its object will automatically be initialized
    ) throws Exception {
        // formula: h(cd)2
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);


        //formula: haap
        http.authorizeHttpRequests().anyRequest().permitAll();

//
//        // here, we are assigning permission according to their roles.(who can have access to what)
//        http.authorizeHttpRequests()
//                //assigning signup & signin ---> for all
//                .requestMatchers("/api/v1/auth/signup",
//                        "/api/v1/auth/usersignin",
//                        "/api/v1/auth/content-manager-signup",
//                        "/api/v1/auth/blog-manager-signup",
//                        "/api/v1/auth/login-with-otp")
//                .permitAll()
//
//                //assigning car-manager ---> for authenticated users only
//                .requestMatchers("/api/cars/addCar")
//                .hasRole("CONTENTMANAGER")
//                .anyRequest().authenticated();

        return http.build(); //it will return a SecurityFilterChain object

    }

//        // 1st approach : to encrypt
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}


















