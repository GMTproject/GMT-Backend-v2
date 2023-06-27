package com.pmn.gmt.domain.user.exception;

import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;

public class RoleNotExistException extends BasicException {
    public RoleNotExistException() {
        super(ErrorCode.ROLE_NOT_EXIST);
    }
}
