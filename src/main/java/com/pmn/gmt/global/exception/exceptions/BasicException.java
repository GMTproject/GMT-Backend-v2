package com.pmn.gmt.global.exception.exceptions;

import com.pmn.gmt.global.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BasicException extends RuntimeException{
    private ErrorCode errorCode;
}
