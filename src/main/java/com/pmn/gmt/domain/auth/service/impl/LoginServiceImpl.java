package com.pmn.gmt.domain.auth.service.impl;

import com.pmn.gmt.domain.auth.presentation.data.dto.LoginDto;
import com.pmn.gmt.domain.auth.presentation.data.responseDto.LoginResponseDto;
import com.pmn.gmt.domain.auth.service.LoginService;
import com.pmn.gmt.domain.auth.util.AuthUtil;
import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import com.pmn.gmt.global.gauth.util.GAuthProperties;
import com.pmn.gmt.domain.user.exception.RoleNotExistException;
import com.pmn.gmt.global.security.jwt.JwtTokenProvider;
import gauth.GAuth;
import gauth.GAuthToken;
import gauth.GAuthUserInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    private GAuthProperties gAuthProperties;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;
    private GAuth gAuth;

    private AuthUtil authUtil;


    @SneakyThrows
    @Override
    public LoginResponseDto execute(LoginDto loginDto) {
        authUtil.authLog("LoginResponseDto execute");
        System.out.println("loginDto.getCode() : " + loginDto.getCode());
        System.out.println("gAuthProperties.getClientId() : " + gAuthProperties.getClientId());
        System.out.println("gAuthProperties.getClientSecret() : " + gAuthProperties.getClientSecret());
        System.out.println("gAuthProperties.getRedirectUri() : " + gAuthProperties.getRedirectUri());
        GAuthToken gAuthToken = gAuth.generateToken(
                loginDto.getCode(),
                gAuthProperties.getClientId(),
                gAuthProperties.getClientSecret(),
                gAuthProperties.getRedirectUri()
        );
        System.out.println("토큰 " + gAuthToken);
        GAuthUserInfo gAuthUserInfo = gAuth.getUserInfo(gAuthToken.getAccessToken());
        UserRole role = getRoleByGauthInfo(gAuthUserInfo.getRole(), gAuthUserInfo.getEmail());
        String token = gAuthToken.getAccessToken();

        System.out.println("token : " + token);

        String accessToken = jwtTokenProvider.generateAccessToken(gAuthUserInfo.getEmail(), role);
        String refreshToken = jwtTokenProvider.generateRefreshToken(gAuthUserInfo.getEmail(), role);
        ZonedDateTime accessExp = jwtTokenProvider.getAccessExpiredTime();
        ZonedDateTime refreshExp = jwtTokenProvider.getRefreshExpiredTime();

        System.out.println("accessToken : " + accessToken);

        createUserOrRefreshToken(gAuthUserInfo, refreshToken, token);

        return new LoginResponseDto(
                accessToken,
                refreshToken,
                accessExp,
                refreshExp
        );
    }

    private UserRole getRoleByGauthInfo(String role, String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            switch (role) {
                case "ROLE_STUDENT":
                    return UserRole.STUDENT;
                case "ROLE_TEACHER":
                    return UserRole.TEACHER;
                default:
                    throw new RoleNotExistException();
            }
        }
        if (user.getRole().equals(UserRole.TEACHER)) {
            return UserRole.TEACHER;
        }
        return UserRole.STUDENT;
    }

    private void createUserOrRefreshToken(GAuthUserInfo gAuthUserInfo, String refreshToken, String token) {
        User userInfo = userRepository.findByEmail(gAuthUserInfo.getEmail());
        if (userInfo == null) {
            authUtil.saveNewUser(gAuthUserInfo, refreshToken, token);
        } else {
            authUtil.saveNewRefreshToken(userInfo, refreshToken, token);
        }
    }
}
