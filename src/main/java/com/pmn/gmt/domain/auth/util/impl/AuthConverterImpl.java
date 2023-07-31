package com.pmn.gmt.domain.auth.util.impl;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.pmn.gmt.domain.auth.presentation.data.reqeuestDto.LoginRequestDto;
import com.pmn.gmt.domain.auth.util.AuthConverter;
import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class AuthConverterImpl implements AuthConverter {
    private final UserRepository userRepository;

    public AuthConverterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    public RefreshTokenDto toDto(String refreshToken, String deviceToken) {
        return new RefreshTokenDto(
                deviceToken,
                refreshToken
        );
    }

    @Override
    public RefreshToken toEntity(User userInfo, String refreshToken) {
        return new RefreshToken(
                userInfo.getId(),
                refreshToken
        );
    }

    @Override
    public RefreshToken toEntity(int userId, String refreshToken) {
        return new RefreshToken(
                userId,
                refreshToken
        );
    }
}
