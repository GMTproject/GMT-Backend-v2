package com.pmn.gmt.global.gauth;

import gauth.GAuth;
import gauth.GAuthToken;
import gauth.GAuthUserInfo;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class GAuthAdapter implements GAuthPort {
    private GAuth gAuth;
    private GAuthProperties gAuthProperties;

    @Override
    @SneakyThrows
    public GAuthToken queryGAuthToken(String code) {
        return gAuth.generateToken(
                code,
                gAuthProperties.getClientId(),
                gAuthProperties.getClientSecret(),
                gAuthProperties.getRedirectUrl()
        );
    }

    @Override
    @SneakyThrows
    public GAuthUserInfo queryGAuthUserInfo(String accessToken) {
        return gAuth.getUserInfo(accessToken);
    }
}
