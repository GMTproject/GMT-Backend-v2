package com.pmn.gmt.domain.auth.util.impl;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.reqeuestDto.LoginRequestDto;
import com.pmn.gmt.domain.auth.util.AuthConverter;
import com.pmn.gmt.domain.user.domain.entity.User;
import org.springframework.stereotype.Component;

@Component
public class AuthConverterImpl implements AuthConverter {
    @Override
    public LoginDto toDto(LoginRequestDto loginRequestDto) {
        return new LoginDto(
                loginRequestDto.getCode().getCode()
        );
    }

    @Override
    public LoginDto toDto(String code) {
        return new LoginDto(
                code
        );
    }

    @Override
    public RefreshToken toEntity(User userInfo, String refreshToken) {
        return new RefreshToken(
                userInfo.getId(),
                refreshToken
        );
    }
}
