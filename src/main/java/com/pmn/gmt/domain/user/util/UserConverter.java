package com.pmn.gmt.domain.user.util;

import com.pmn.gmt.domain.user.domain.entity.User;
import com.pmn.gmt.domain.user.domain.entity.role.UserRole;
import gauth.GAuthUserInfo;

public interface UserConverter {
    User toEntity(GAuthUserInfo gAuthUserInfo, UserRole role);
}
