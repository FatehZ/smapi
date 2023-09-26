package com.ktxdevelopment.gatewayservice.auth.security.config;


import com.ktxdevelopment.siratumustakim.auth.security.filter.AdminSecurityFilter;
import com.ktxdevelopment.siratumustakim.auth.security.filter.ApiKeyAuthenticationFilter;
import com.ktxdevelopment.siratumustakim.auth.security.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.ktxdevelopment.siratumustakim.auth.user.model.Role.*;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ApiKeyAuthenticationFilter apiKeyAuthenticationFilter;
    private final AdminSecurityFilter adminSecurityFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests((requests) -> requests

                        .requestMatchers("/api/v1/auth/**").permitAll()

                        .requestMatchers("/api/v1/manager/**").hasAnyRole(MANAGER.name(), ADMIN.name())

                        .requestMatchers("/api/v1/user/**").hasAnyRole(USER.name(), MANAGER.name(), ADMIN.name())

                        .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                        .requestMatchers("/api/v1/post/**").permitAll()

                        .requestMatchers("/api/v1/category/**").permitAll()

                        .requestMatchers("/api/v1/tag/**").permitAll()

                        .anyRequest().authenticated()
                ).sessionManagement((sec) -> {
                    sec.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                })
                .authenticationProvider(authenticationProvider)

                .addFilterBefore(apiKeyAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(adminSecurityFilter, UsernamePasswordAuthenticationFilter.class)

                .logout((form) ->
                        form.logoutUrl("/api/v1/auth/logout").addLogoutHandler(logoutHandler).logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                        .permitAll()
                );

        return http.build();
    }
}
