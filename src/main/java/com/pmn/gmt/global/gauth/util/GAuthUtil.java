package com.pmn.gmt.global.gauth.util;

import gauth.GAuthToken;
import gauth.GAuthUserInfo;

public interface GAuthUtil {
    GAuthToken toGAuthToken(String code);
    GAuthUserInfo toGAuthUserInfo(String accessToken);
}
