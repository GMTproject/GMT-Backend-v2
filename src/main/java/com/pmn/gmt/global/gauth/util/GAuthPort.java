package com.pmn.gmt.global.gauth.util;

import gauth.GAuthToken;
import gauth.GAuthUserInfo;

public interface GAuthPort {
    GAuthToken queryGAuthToken(String code);
    GAuthUserInfo queryGAuthUserInfo(String accessToken);
}
