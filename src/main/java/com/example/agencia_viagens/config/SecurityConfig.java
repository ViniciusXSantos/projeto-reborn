package com.example.agencia_viagens.config;

import com.example.agencia_viagens.service.impl.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        return http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers( "/assets/**","/img/**", "/js/**", "/css/**", "/error", "/h2/**").permitAll()
                                .anyRequest().hasAuthority("ADMIN")
                )
                //.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .formLogin(login -> login.loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/home", true)) 
                .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())
                .userDetailsService(userDetailsService)
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.disable())
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  

}
