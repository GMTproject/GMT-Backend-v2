package com.pmn.gmt.global.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmn.gmt.global.security.jwt.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    ObjectMapper objectMapper;
    JwtTokenProvider jwtTokenProvider;
    @Bean
    protected UserDetailsService userDetailsService() {
        return (username) -> null;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .cors().and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/map").permitAll()

                .antMatchers(HttpMethod.GET,"/teachers/**").hasAnyRole("TEACHER", "STUDENT")

                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth").permitAll()
                .antMatchers(HttpMethod.DELETE, "/auth").authenticated()

                .anyRequest().permitAll()
                .and()
                .exceptionHandling()
                .and()
                .anonymous().authorities("GUEST")
                .and()
                .apply(new FilterConfig(jwtTokenProvider, objectMapper))
                .and()
                .logout();

        return http.build();

    }
}
