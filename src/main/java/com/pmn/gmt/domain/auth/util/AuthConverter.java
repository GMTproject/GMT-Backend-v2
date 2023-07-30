package com.pmn.gmt.domain.auth.util;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.pmn.gmt.domain.auth.presentation.data.reqeuestDto.LoginRequestDto;
import com.pmn.gmt.domain.user.domain.entity.User;

public interface AuthConverter {
    LoginDto toDto(LoginRequestDto loginRequestDto);
    LoginDto toDto(String code);
    RefreshTokenDto toDto(String refreshToken, String deviceToken);
    RefreshToken toEntity(User userInfo, String refreshToken);
    RefreshToken toEntity(int userId, String refreshToken);
}
