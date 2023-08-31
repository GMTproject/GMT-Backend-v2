package com.pmn.gmt.domain.map.exception;

import com.pmn.gmt.global.exception.ErrorCode;
import com.pmn.gmt.global.exception.exceptions.BasicException;

public class ClassRoomNotFoundException extends BasicException {
    public ClassRoomNotFoundException() {
        super(ErrorCode.NOT_FOUND_CLASSROOM);
    }
}
