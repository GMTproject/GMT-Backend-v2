package com.pmn.gmt.domain.auth.util;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.reqeuestDto.LoginRequestDto;
import com.pmn.gmt.domain.user.domain.entity.User;

public interface AuthConverter {
    LoginDto toDto(LoginRequestDto loginRequestDto);
    LoginDto toDto(String code);

    RefreshToken toEntity(User userInfo, String refreshToken);
}
