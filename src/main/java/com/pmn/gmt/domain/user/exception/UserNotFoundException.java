package com.pmn.gmt.domain.user.exception;

import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;

public class UserNotFoundException extends BasicException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
