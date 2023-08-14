package com.pmn.gmt.domain.user.util;

import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import com.pmn.gmt.domain.user.presentation.data.dto.UserInfoDto;
import com.pmn.gmt.domain.user.presentation.data.responseDto.UserInfoResponseDto;
import gauth.GAuthUserInfo;

public interface UserConverter {
    User toEntity(GAuthUserInfo gAuthUserInfo, UserRole role);
    UserInfoDto toDto(User user);

    UserInfoResponseDto toResponseDto(UserInfoDto userInfoDto);
}
