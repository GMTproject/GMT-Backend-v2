package com.pmn.gmt.global.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmn.gmt.global.security.filter.ExceptionFilter;
import com.pmn.gmt.global.security.filter.JwtTokenFilter;
import com.pmn.gmt.global.security.filter.RequestLogFilter;
import com.pmn.gmt.global.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class FilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenProvider jwtTokenProvider;
    private ObjectMapper objectMapper;

    @Override
    public void configure(HttpSecurity builder) {
        JwtTokenFilter jwtTokenFilter = new JwtTokenFilter(jwtTokenProvider);
        ExceptionFilter exceptionFilter = new ExceptionFilter(objectMapper);
        RequestLogFilter requestLogFilter = new RequestLogFilter();

        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(requestLogFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
