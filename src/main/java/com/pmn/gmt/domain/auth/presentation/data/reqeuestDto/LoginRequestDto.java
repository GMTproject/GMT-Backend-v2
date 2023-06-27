package com.pmn.gmt.domain.auth.presentation.data.reqeuestDto;

import gauth.GAuthCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDto {
    private GAuthCode code;
}
