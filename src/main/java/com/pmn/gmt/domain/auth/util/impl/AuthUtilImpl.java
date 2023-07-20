package com.pmn.gmt.domain.auth.util.impl;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.auth.domain.repository.RefreshTokenRepository;
import com.pmn.gmt.domain.auth.util.AuthUtil;
import com.pmn.gmt.domain.user.domain.entity.DeviceToken;
import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.domain.repository.DeviceTokenRepository;
import com.pmn.gmt.domain.user.exception.RoleNotExistException;
import com.pmn.gmt.domain.user.domain.repository.UserRepository;
import com.pmn.gmt.domain.user.util.UserConverter;
import gauth.GAuthUserInfo;
import org.springframework.stereotype.Component;

@Component
public class AuthUtilImpl implements AuthUtil {

    public AuthUtilImpl(
            RefreshTokenRepository refreshTokenRepository,
            UserConverter userConverter,
            UserRepository userRepository,
            DeviceTokenRepository deviceTokenRepository
    ) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userConverter = userConverter;
        this.userRepository = userRepository;
        this.deviceTokenRepository = deviceTokenRepository;
    }

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final DeviceTokenRepository deviceTokenRepository;

    @Override
    public void saveNewUser(GAuthUserInfo gAuthUserInfo, String refreshToken, String token) {
        User signInUserInfo = userConverter.toEntity(gAuthUserInfo, getRole(gAuthUserInfo));
        userRepository.save(signInUserInfo);
        saveNewRefreshToken(signInUserInfo, refreshToken, token);
    }

    @Override
    public RefreshToken saveNewRefreshToken(User userInfo, String refreshToken, String token) {
        deviceTokenRepository.save(new DeviceToken(userInfo.getId(), userInfo, token != null ? token : ""));
        RefreshToken refreshTokenEntity = new RefreshToken(userInfo.getId(), refreshToken);
        refreshTokenRepository.save(refreshTokenEntity);
        return refreshTokenEntity;
    }

    @Override
    public void authLog(String name) {
        System.out.println("=================================================");
        System.out.println("함수 이름 : " + name);
        System.out.println("=================================================");
    }

    private UserRole getRole(GAuthUserInfo gAuthUserInfo) {
        switch (gAuthUserInfo.getRole()) {
            case "ROLE_STUDENT":
                return UserRole.STUDENT;
            case "ROLE_TEACHER":
                return UserRole.TEACHER;
            default:
                throw new RoleNotExistException();
        }
    }
}
