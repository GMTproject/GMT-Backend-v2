package com.pmn.gmt.domain.auth.util;

import com.pmn.gmt.domain.auth.domain.entity.RefreshToken;
import com.pmn.gmt.domain.user.domain.entity.User;
import gauth.GAuthUserInfo;

public interface AuthUtil {
    void saveNewUser(GAuthUserInfo gAuthUserInfo, String refreshToken, String token);

    RefreshToken saveNewRefreshToken(User userInfo, String refreshToken, String token);
}
