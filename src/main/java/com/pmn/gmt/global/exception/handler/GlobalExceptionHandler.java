package com.pmn.gmt.global.exception.handler;

import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;
import com.pmn.gmt.global.exception.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @ExceptionHandler(BasicException.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(HttpServletRequest request, BasicException e) {
        log.error(e.getErrorCode().getDescription());
        log.error(request.getRequestURI());
        ErrorCode errorCode = e.getErrorCode();
        return ResponseEntity.status(errorCode.getStatus())
                .body(new ErrorResponse(errorCode.getStatus(), errorCode.getDescription()));
    }
}
