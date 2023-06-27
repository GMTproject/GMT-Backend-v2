package com.pmn.gmt.domain.auth.exception;

import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;

public class InvalidTokenException extends BasicException {
    public InvalidTokenException() {
        super(ErrorCode.UNAUTHORIZED);
    }
}
