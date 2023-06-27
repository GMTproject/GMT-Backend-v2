package com.pmn.gmt.domain.auth.service;

import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginResponseDto;

public interface LoginService {
    LoginResponseDto execute(LoginDto loginDto);
}