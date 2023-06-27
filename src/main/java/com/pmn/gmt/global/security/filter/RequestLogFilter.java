package com.pmn.gmt.global.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestLogFilter extends OncePerRequestFilter {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("client ip = " + request.getRemoteAddr());
        log.info("request method = " + request.getMethod());
        log.info("request url = " + request.getRequestURI());
        log.info("client info = " + request.getHeader("User-Agent"));
        filterChain.doFilter(request, response);
        log.info("response status = " + response.getStatus());
    }
}
