package com.pmn.gmt.global.gauth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GAuthProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
}
