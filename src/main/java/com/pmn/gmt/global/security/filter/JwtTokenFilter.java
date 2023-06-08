package com.pmn.gmt.global.security.filter;

import com.pmn.gmt.global.security.jwt.JwtTokenProvider;
import org.hibernate.annotations.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    private JwtTokenProvider jwtTokenProvider;
    private Logger log = LoggerFactory.getLogger(getClass());

    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);
        if (token != null && !token.isBlank()) {
             Authentication authentication = jwtTokenProvider.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("current user email = " + authentication.getName());
        }
        filterChain.doFilter(request, response);
    }
}





