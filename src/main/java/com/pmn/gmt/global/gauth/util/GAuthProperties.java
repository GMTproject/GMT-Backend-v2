package com.pmn.gmt.global.gauth.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class GAuthProperties {
    private final String clientId;
    private final String clientSecret;
    private final String redirectUri;

    public GAuthProperties(@Value("${gauth.clientId}") String clientId,
                           @Value("${gauth.clientSecret}") String clientSecret,
                           @Value("${gauth.redirectUri}")String redirectUri) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }
}
