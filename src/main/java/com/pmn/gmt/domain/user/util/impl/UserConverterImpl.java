package com.pmn.gmt.domain.user.util.impl;

import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.presentation.data.dto.UserInfoDto;
import com.pmn.gmt.domain.user.presentation.data.responseDto.UserInfoResponseDto;
import com.pmn.gmt.domain.user.util.UserConverter;
import gauth.GAuthUserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public User toEntity(GAuthUserInfo gAuthUserInfo, UserRole role) {
        return new User(
                0,
                gAuthUserInfo.getName(),
                gAuthUserInfo.getEmail(),
                role
        );
    }

    @Override
    public UserInfoDto toDto(User user) {
        return new UserInfoDto(
                user.getName()
        );
    }

    @Override
    public UserInfoResponseDto toResponseDto(UserInfoDto userInfoDto) {
        return new UserInfoResponseDto(
                userInfoDto.getName()
        );
    }
}
