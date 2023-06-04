package com.pmn.gmt.global.gauth.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GAuthProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUrl;
}
