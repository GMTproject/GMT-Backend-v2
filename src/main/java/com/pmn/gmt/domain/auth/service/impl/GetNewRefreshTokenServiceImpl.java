package com.pmn.gmt.domain.auth.service.impl;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.domain.repository.RefreshTokenRepository;
import com.pmn.gmt.domain.auth.exception.ExpiredTokenException;
import com.pmn.gmt.domain.auth.exception.InvalidTokenException;
import com.pmn.gmt.domain.auth.presentation.data.dto.RefreshTokenDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.RefreshTokenResponseDto;
import com.pmn.gmt.domain.auth.service.GetNewRefreshTokenService;
import com.pmn.gmt.domain.auth.util.AuthConverter;
import com.pmn.gmt.domain.user.domain.entity.DeviceToken;
import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.domain.repository.DeviceTokenRepository;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import com.pmn.gmt.domain.user.exception.UserNotFoundException;
import com.pmn.gmt.global.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class GetNewRefreshTokenServiceImpl implements GetNewRefreshTokenService{

    private JwtTokenProvider jwtTokenProvider;
    private RefreshTokenRepository refreshTokenRepository;
    private AuthConverter authConverter;
    private DeviceTokenRepository deviceTokenRepository;
    private UserRepository userRepository;

    @Override
    public RefreshTokenResponseDto execute(RefreshTokenDto refreshTokenDto) {
        String refreshToken = jwtTokenProvider.parseToken(refreshTokenDto.getRefreshToken());
        if(refreshToken == null)
            throw new InvalidTokenException();
        RefreshToken existingRefreshToken = refreshTokenRepository.findByToken(refreshToken);
        if(existingRefreshToken == null)
            throw new ExpiredTokenException();
        String email = jwtTokenProvider.extractEmailFromRefreshToken(refreshToken);
        UserRole role = jwtTokenProvider.extractRoleFromRefreshToken(refreshToken);

        String newAccessToken = jwtTokenProvider.generateAccessToken(email, role);
        String newRefreshToken = jwtTokenProvider.generateRefreshToken(email, role);
        ZonedDateTime accessExp = jwtTokenProvider.getAccessExpiredTime();
        ZonedDateTime refreshExp = jwtTokenProvider.getRefreshExpiredTime();

        refreshTokenRepository.save(authConverter.toEntity(
                existingRefreshToken.getUserId(),
                newRefreshToken
        ));

        refreshTokenRepository.delete(existingRefreshToken);

        User user = userRepository.findByEmail(email);
        if(user == null)
             throw new UserNotFoundException();

        String deviceToken = refreshTokenDto.getDeviceToken();
        if(deviceToken == null)
            deviceToken = "";

        deviceTokenRepository.save(new DeviceToken(user.getId(), user, deviceToken));

        return new RefreshTokenResponseDto(
                newAccessToken,
                newRefreshToken,
                accessExp,
                refreshExp
        );
    }
}
