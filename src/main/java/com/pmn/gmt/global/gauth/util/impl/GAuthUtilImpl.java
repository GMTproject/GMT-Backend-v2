package com.pmn.gmt.global.gauth.util.impl;

import com.pmn.gmt.global.gauth.util.GAuthProperties;
import com.pmn.gmt.global.gauth.util.GAuthUtil;
import gauth.GAuth;
import gauth.GAuthToken;
import gauth.GAuthUserInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GAuthUtilImpl implements GAuthUtil {
    private GAuth gAuth;
    private GAuthProperties gAuthProperties;

    @Override
    @SneakyThrows
    public GAuthToken toGAuthToken(String code) {
        return gAuth.generateToken(
                code,
                gAuthProperties.getClientId(),
                gAuthProperties.getClientSecret(),
                gAuthProperties.getRedirectUri()
        );
    }

    @Override
    @SneakyThrows
    public GAuthUserInfo toGAuthUserInfo(String accessToken) {
        return gAuth.getUserInfo(accessToken);
    }
}
