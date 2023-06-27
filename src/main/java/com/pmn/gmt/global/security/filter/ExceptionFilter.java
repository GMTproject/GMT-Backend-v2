package com.pmn.gmt.global.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;
import com.pmn.gmt.global.exception.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ExceptionFilter extends OncePerRequestFilter {
    private ObjectMapper objectMapper;
    private Logger log = LoggerFactory.getLogger(getClass());

    public ExceptionFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BasicException e) {
            log.error(e.getMessage());
            sendError(response, e.getErrorCode());
        } catch (Exception e) {
            log.error(e.getMessage());
            response.setCharacterEncoding("UTF-8");
            sendError(response, ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    private void sendError(HttpServletResponse response, ErrorCode errorCode)  throws IOException {
        ErrorResponse errorResponse = new ErrorResponse( errorCode.getStatus(),errorCode.getDescription());
        String responseString = objectMapper.writeValueAsString(errorResponse);
        response.setStatus(errorCode.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getWriter().write(responseString);
    }
}

